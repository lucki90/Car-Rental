package com.sda.luckyrent.controller;


import com.sda.luckyrent.model.Car;
import com.sda.luckyrent.service.CarService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/cars")
public class CarController {

    @Autowired
    private CarService carService;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Car create(@RequestBody Car car) {
        return carService.create(car);
    }

//    @GetMapping
//    @ResponseStatus(HttpStatus.OK)
//    public List<Car> getAll() {
//        return carService.getAll();
//    }

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public List<Car> search(
            @RequestParam(value = "brand", defaultValue = "") String brand,
            @RequestParam(value = "model", defaultValue = "") String model,
            @RequestParam(value = "minPrice", defaultValue = "0") Integer minPrice,
            @RequestParam(value = "maxPrice", required = false) Integer maxPrice
                            ){
        return carService.search(brand,model,minPrice,maxPrice);
    }

    @GetMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public Car getById(@PathVariable Long id) {
        return carService.getById(id);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void delete(@PathVariable Long id) {
        carService.delete(id);
    }

    @PutMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public Car update(@PathVariable Long id,
                      @RequestBody @Valid Car car,
                      BindingResult bindingResult) {
        return carService.update(id, car, bindingResult);
    }
}
