package com.sda.luckyrent.controller;

import com.sda.luckyrent.model.Car;
import com.sda.luckyrent.model.CarSpecification;
import com.sda.luckyrent.service.CarSpecificationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.HttpStatus;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import javax.websocket.server.PathParam;
import java.time.LocalDate;
import java.util.List;

@RestController
@RequestMapping("/car-specifications")
public class CarSpecificationController {

    @Autowired
    private CarSpecificationService carSpecificationService;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public CarSpecification create(@RequestBody CarSpecification carSpecification) {
        return carSpecificationService.create(carSpecification);
    }

    @GetMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public CarSpecification getById(@PathVariable Long id) {
        return carSpecificationService.getById(id);
    }

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public List<CarSpecification> search(
            @RequestParam(value = "fromDate", required = false) @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate fromDate,
            @RequestParam(value = "toDate",required = false) @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate toDate,
            @RequestParam(value = "colour",required = false, defaultValue = "") String colour
    ) {
        return carSpecificationService.search(fromDate, toDate, colour);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
public void delete(@PathVariable Long id){
    carSpecificationService.delete(id);
    }

    @PutMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public CarSpecification update(@PathVariable Long id,
                                   @RequestBody @Valid CarSpecification carSpecification,
                                   BindingResult bindingResult){
        return carSpecificationService.update(id, carSpecification,bindingResult);
    }
}

