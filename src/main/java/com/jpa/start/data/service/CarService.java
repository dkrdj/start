package com.jpa.start.data.service;

import com.jpa.start.data.dto.CarDto;

import java.util.List;
import java.util.Optional;

public interface CarService {
    //모든 게시글 조회
    List<CarDto> getCarList();

    //글을 읽자 (상세글 조회)
    Optional<CarDto> readCar(String vin);

    //글을 작성하자.
    void writeCar(CarDto carDto);

    //글을 수정하자.
    Optional<CarDto> modifyCar(String vin, Integer price);

    //글을 삭제하자.
    void deleteCar(String vin);
}


	

