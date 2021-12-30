package com.irfancimen.pnm.service;

import com.google.maps.GeoApiContext;
import com.google.maps.PlacesApi;
import com.google.maps.errors.ApiException;
import com.google.maps.model.LatLng;
import com.google.maps.model.PlacesSearchResponse;
import com.irfancimen.pnm.exception.GeomApiException;
import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import java.io.IOException;

@Component
@RequiredArgsConstructor
public class GeomService {

    private static final Logger LOGGER = LoggerFactory.getLogger(GeomService.class);

    private final GeoApiContext geoApiContext;

    public PlacesSearchResponse queryPlacesNearby(LatLng location, int radius) {
        try {
            return PlacesApi.nearbySearchQuery(geoApiContext, location).radius(radius).await();
        } catch (IOException | InterruptedException| ApiException ex) {
            LOGGER.error("Failed to get places from google place api, cause is " + ex.getCause());
            throw new GeomApiException("External service error, Getting an error communicate with google map service");
        }
    }

}
