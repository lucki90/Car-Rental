package com.sda.luckyrent.service;

import com.sda.luckyrent.model.Car;
import com.sda.luckyrent.repository.CarRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CarService {

    @Autowired
    private CarRepository carRepository;

    public Car create(Car car){
        return carRepository.save(car);
    }

    public List<Car> getAll(){
        return carRepository.findAll();
    }
}
