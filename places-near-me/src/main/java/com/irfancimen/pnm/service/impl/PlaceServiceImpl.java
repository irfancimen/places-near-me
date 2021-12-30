package com.irfancimen.pnm.service.impl;

import com.google.gson.Gson;
import com.google.maps.model.LatLng;
import com.google.maps.model.PlacesSearchResponse;
import com.irfancimen.pnm.entity.Place;
import com.irfancimen.pnm.model.NearbySearch;
import com.irfancimen.pnm.model.dto.PlacesRequestDto;
import com.irfancimen.pnm.repository.PlaceRepository;
import com.irfancimen.pnm.service.GeomService;
import com.irfancimen.pnm.service.PlaceService;
import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class PlaceServiceImpl implements PlaceService {

    private static final Logger LOGGER = LoggerFactory.getLogger(PlaceServiceImpl.class);

    private final PlaceRepository placeRepository;

    private final GeomService geomService;

    private final Gson gson;

    @Override
    public List<NearbySearch> getNearbyPlaces(PlacesRequestDto request) {
        LOGGER.info("getNearbyPlaces() is called, request {}", request);
        Optional<Place> place =  placeRepository.findPlaceByLatAndLngAndRadius(request.lat, request.lng, request.radius);
        if (place.isPresent()) {
            LOGGER.info("Places fetched from db...");
            return Arrays.asList(gson.fromJson(place.get().getPlaces(), NearbySearch[].class));
        }
        LatLng location = new LatLng(Double.parseDouble(request.lat), Double.parseDouble(request.lng));
        PlacesSearchResponse resp = geomService.queryPlacesNearby(location, request.radius);
        String jsonInString =  gson.toJson(resp.results);
        Place dbPlace = Place.builder().lat(request.lat).lng(request.lng).radius(request.radius)
                .places(jsonInString)
                .build();
        placeRepository.save(dbPlace);
        LOGGER.info("A new place saved to database. Place is {}", dbPlace);
        return Arrays.asList(gson.fromJson(jsonInString, NearbySearch[].class));
    }
}
