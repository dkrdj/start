package com.jpa.start.config;

import com.jpa.start.data.repository.CarRepository;
import com.jpa.start.data.repository.CarRepositoryV1;
import com.jpa.start.data.service.CarService;
import com.jpa.start.data.service.CarServiceImpl;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.persistence.EntityManager;

@Configuration
public class JpaConfig {
    private final EntityManager em;

    public JpaConfig(EntityManager em) {
        this.em = em;
    }

    @Bean
    public CarService carService() {
        return new CarServiceImpl(carRepository());
    }

    @Bean
    public CarRepository carRepository() {
        return new CarRepositoryV1(em);
    }
}
