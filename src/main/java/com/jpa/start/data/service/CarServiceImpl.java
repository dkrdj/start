package com.jpa.start.data.service;

import com.jpa.start.data.dto.CarDto;
import com.jpa.start.data.repository.CarRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
@Transactional
public class CarServiceImpl implements CarService {

    private final CarRepository carRepository;

    @Override
    public List<CarDto> getCarList() {
        return carRepository.findAll();
    }

    @Override
    public Optional<CarDto> readCar(String vin) {
        Optional<CarDto> optionalCar = carRepository.findByVin(vin);
        if (optionalCar.isPresent()) {
            carRepository.updateViewCnt(vin);
        }
        return optionalCar;
    }

    @Override
    public void writeCar(CarDto carDto) {
        carRepository.save(carDto);
    }

    @Override
    public Optional<CarDto> modifyCar(String vin, Integer price) {
        carRepository.update(vin, price);
        return carRepository.findByVin(vin);
    }

    @Override
    public void deleteCar(String vin) {
        carRepository.delete(vin);
    }

}
