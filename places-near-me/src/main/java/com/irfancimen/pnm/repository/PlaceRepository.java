package com.irfancimen.pnm.repository;

import com.irfancimen.pnm.entity.Place;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.Optional;

public interface PlaceRepository extends MongoRepository<Place, String> {

    Optional<Place> findPlaceByLatAndLngAndRadius(String lat, String lng, int radius);

}
