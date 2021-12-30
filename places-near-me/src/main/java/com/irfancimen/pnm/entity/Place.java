package com.irfancimen.pnm.entity;

import lombok.Builder;
import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@Builder
@Document(collection = "place")
public class Place {

    @Id
    private String id;

    private String lat;

    private String lng;

    private int radius;

    private String places;
}
