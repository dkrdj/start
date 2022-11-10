package com.jpa.start.data.repository;

import com.jpa.start.data.dto.CarDto;
import com.jpa.start.data.entity.Car;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;


@Repository
public class CarRepositoryV1 implements CarRepository {

    private final EntityManager em;

    public CarRepositoryV1(EntityManager em) {
        this.em = em;
    }

    @Override
    public List<CarDto> findAll() {
        String jpql = "select i from Car i";
        List<Car> list = em.createQuery(jpql, Car.class).getResultList();
        return list.stream()
                .map(m -> m.toDto())
                .collect(Collectors.toList());
    }

    @Override
    public Optional<CarDto> findByVin(String vin) {
        Car car = em.find(Car.class, vin);
        return Optional.ofNullable(car.toDto());
    }

    @Override
    public CarDto save(CarDto carDto) {
        Car car = new Car().builder()
                .mileage(carDto.getMileage())
                .manufacturerCode(carDto.getManufacturerCode())
                .manufacturer(carDto.getManufacturer())
                .yearOfManufacture(carDto.getYearOfManufacture())
                .viewCnt(carDto.getViewCnt())
                .modelName(carDto.getModelName())
                .price(carDto.getPrice())
                .vin(carDto.getVin()).build();
        em.persist(car);
        return carDto;
    }

    @Override
    public void update(String vin, Integer price) {
        Car car = em.find(Car.class, vin);
        car.updatePrice(price);
    }

    @Override
    public void delete(String vin) {
        em.remove(em.find(Car.class, vin));
    }

    @Override
    public void updateViewCnt(String vin) {
        Car car = em.find(Car.class, vin);
        car.updateViewCnt();
    }
}
