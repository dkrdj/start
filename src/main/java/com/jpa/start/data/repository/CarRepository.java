package com.jpa.start.data.repository;


import com.jpa.start.data.dto.CarDto;

import java.util.List;
import java.util.Optional;

public interface CarRepository {
    List<CarDto> findAll();

    Optional<CarDto> findByVin(String vin);

    CarDto save(CarDto carDto);

    void update(String vin, Integer price);

    void delete(String vin);

    void updateViewCnt(String vin);
}
