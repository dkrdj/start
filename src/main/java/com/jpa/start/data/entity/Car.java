package com.jpa.start.data.entity;

import com.jpa.start.data.dto.CarDto;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Car {
    @Id
    private String vin;

    @Column(name = "modelname")
    private String modelName;
    private String manufacturer;
    private Integer yearOfManufacture;
    private Integer mileage;
    private Integer price;
    private Integer manufacturerCode;
    private Integer viewCnt;

    public void updateViewCnt() {
        this.viewCnt++;
    }

    public void updatePrice(Integer price) {
        this.price = price;
    }

    public CarDto toDto() {
        return new CarDto(this.vin, this.modelName, this.manufacturer, this.yearOfManufacture,
                this.mileage, this.price, this.manufacturerCode, this.viewCnt);
    }
}
