package com.jpa.start.controller;

import com.jpa.start.data.dto.CarDto;
import com.jpa.start.data.service.CarService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;
import java.util.Optional;

@Controller
@RequiredArgsConstructor
public class CarController {
    private final CarService carService;

    @GetMapping("/")
    public String showIndex() {
        return "redirect:index";
    }

    @GetMapping("list")
    public String list(Model model) {
        System.out.println(carService);
        List<CarDto> list = carService.getCarList();
        model.addAttribute("list", list);
        return "list";
    }

    @GetMapping("write")
    public String writeform() {
        return "writeform";
    }

    @PostMapping("write")
    public String write(CarDto carDto) {
        carService.writeCar(carDto);
        return "redirect:list";
    }

    @GetMapping("detail")
    public String detail(Model model, String vin) {
        Optional<CarDto> optionalCar = carService.readCar(vin);
        CarDto CarDto = null;
        if (optionalCar.isPresent()) CarDto = optionalCar.get();
        model.addAttribute("car", CarDto);
        return "detail";
    }

    @PostMapping("delete")
    public String delete(String vin) {
        carService.deleteCar(vin);
        return "redirect:list";
    }

    @GetMapping("update")
    public String updateform(Model model, String vin) {
        Optional<CarDto> optionalCar = carService.readCar(vin);
        CarDto CarDto = null;
        if (optionalCar.isPresent()) CarDto = optionalCar.get();
        model.addAttribute("car", CarDto);
        return "updateform";
    }

    @PostMapping("update")
    public String update(String vin, Integer price) {
        Optional<CarDto> optionalCar = carService.modifyCar(vin, price);
        CarDto CarDto = null;
        if (optionalCar.isPresent()) CarDto = optionalCar.get();
        return "redirect:detail?vin=" + CarDto.getVin();
    }
}
