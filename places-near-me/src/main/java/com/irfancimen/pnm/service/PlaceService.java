package com.irfancimen.pnm.service;

import com.irfancimen.pnm.model.NearbySearch;
import com.irfancimen.pnm.model.dto.PlacesRequestDto;

import java.util.List;

public interface PlaceService {

    List<NearbySearch> getNearbyPlaces(PlacesRequestDto requestDto);
}
