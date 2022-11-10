package com.jpa.start.data.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class CarDto {
    private String vin;
    private String modelName;
    private String manufacturer;
    private Integer yearOfManufacture;
    private Integer mileage;
    private Integer price;
    private Integer manufacturerCode;
    private Integer viewCnt;
}
