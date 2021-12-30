package com.irfancimen.pnm.model;

import lombok.Data;

@Data
public class NearbySearch {

    public Geometry geometry;
    public String name;
    public String icon;
    public String placeId;
    public String scope;
    public double rating;
}
