package com.sda.luckyrent.controller;

import com.sda.luckyrent.model.Car;
import com.sda.luckyrent.model.CarClass;
import com.sda.luckyrent.service.CarClassService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.naming.Binding;
import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/car-classes")
public class CarClassController {

    @Autowired
    private CarClassService carClassService;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public CarClass create(@RequestBody CarClass carClass) {
        return carClassService.create(carClass);
    }

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public List<CarClass> search(
            @RequestParam(value = "segment", defaultValue = "") String segment) {
        return carClassService.search(segment);
    }

    @GetMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public CarClass getById(@PathVariable Long id) {
        return carClassService.getById(id);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void delete(@PathVariable Long id) {
        carClassService.delete(id);
    }

    @PutMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public CarClass update(@PathVariable Long id,
                           @RequestBody @Valid CarClass carClass,
                           BindingResult bindingResult) {
        return carClassService.update(id, carClass, bindingResult);
    }
}
