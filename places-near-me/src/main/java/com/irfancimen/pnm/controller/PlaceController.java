package com.irfancimen.pnm.controller;

import com.irfancimen.pnm.model.NearbySearch;
import com.irfancimen.pnm.model.dto.PlacesRequestDto;
import com.irfancimen.pnm.service.PlaceService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("${api.version}")
@RequiredArgsConstructor
public class PlaceController {

    private final PlaceService placeService;

    @GetMapping("/places")
    public ResponseEntity<List<NearbySearch>> getNearbyPlaces(@RequestParam("lat") String lat,
                                                              @RequestParam("lng") String lng,
                                                              @RequestParam("radius") int radius) {
        return ResponseEntity.ok(placeService.getNearbyPlaces(new PlacesRequestDto(lat, lng, radius)));
    }

}
