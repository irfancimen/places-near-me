package com.irfancimen.pnm.model.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotBlank;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class PlacesRequestDto {

    @NotBlank(message = "Latitude properties is required")
    public String lat;

    @NotBlank(message = "Longitude properties is required")
    public String lng;

    @NotBlank(message = "Radius properties is required")
    public int radius;

}
