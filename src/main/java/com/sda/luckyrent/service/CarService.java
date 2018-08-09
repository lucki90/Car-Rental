package com.sda.luckyrent.service;

import com.sda.luckyrent.exception.BindingResultException;
import com.sda.luckyrent.exception.NotFoundException;
import com.sda.luckyrent.model.Car;
import com.sda.luckyrent.repository.CarRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;

import java.util.List;
import java.util.Optional;

@Service
public class CarService {

    @Autowired
    private CarRepository carRepository;

    public Car create(Car car) {
        return carRepository.save(car);
    }

    public List<Car> getAll() {
        return carRepository.findAll();
    }

    public Car getById(Long id) {
        Optional<Car> car = carRepository.findById(id);
        if (!car.isPresent()) {
            throw new NotFoundException(String.format("Car with id %s does not exists", id));
        }
        return car.get();
    }

    public void delete(Long id) {
        if (!carRepository.existsById(id)) {
            throw new NotFoundException(String.format("Car with id %s does not exists", id));
        }
        carRepository.deleteById(id);
    }

    public Car update(Long id, Car car, BindingResult bindingResult) {

        Optional<Car> savedCar = carRepository.findById(id);
        if (!savedCar.isPresent()){
            throw new NotFoundException(String.format("Car with id %s does not exists", id));
        }
        Car dbCar = savedCar.get();

        validateCar(car, dbCar, bindingResult);

        dbCar.updateFrom(car);
        return carRepository.save(dbCar);
    }

    private void validateCar(Car car, Car dbCar, BindingResult bindingResult) {
        if (dbCar != null
                && carRepository.existsById(car.getId())
                && dbCar.equals(car)) {
            FieldError error = new FieldError("car", "id",
                    "Car already exist");
            bindingResult.addError(error);
        }
        if (bindingResult.hasErrors()) {
            throw new BindingResultException(bindingResult);
        }
    }

}
