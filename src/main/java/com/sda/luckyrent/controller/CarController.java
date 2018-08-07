package com.sda.luckyrent.controller;


import com.sda.luckyrent.model.Car;
import com.sda.luckyrent.service.CarService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/cars")
public class CarController {

    @Autowired
    private CarService carService;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Car create (@RequestBody Car car){
        return carService.create(car);
    }

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public List<Car> getAll(){
        return carService.getAll();
    }

}
