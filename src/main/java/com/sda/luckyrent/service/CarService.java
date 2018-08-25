package com.sda.luckyrent.service;

import com.sda.luckyrent.exception.BindingResultException;
import com.sda.luckyrent.exception.NotFoundException;
import com.sda.luckyrent.model.Car;
import com.sda.luckyrent.repository.CarRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.validation.BindingResult;

import java.util.List;
import java.util.Optional;

@Service
public class CarService {

    @Autowired
    private CarRepository carRepository;

    public Car create(Car car) {
        return carRepository.save(car);
    }

    public Car getById(Long id) {
        Optional<Car> car = carRepository.findById(id);
        if (!car.isPresent()) {
            throw new NotFoundException(String.format("Car with id %s does not exists", id));
        }
        return car.get();
    }

    public List<Car> search(String brand, String model, Integer minPrice, Integer maxPrice) {
        if (maxPrice==null){
            maxPrice=Integer.MAX_VALUE;
        }
        return carRepository
                .findByBrandContainingIgnoreCaseAndModelContainingIgnoreCaseAndPriceGreaterThanEqualAndPriceLessThanEqual(
                        brand,model,minPrice,maxPrice);
    }

    public Car update(Long id, Car car, BindingResult bindingResult) {

        Car dbCar = getById(id);
        car.setId(id);
        validateCar(bindingResult);
        dbCar.updateFrom(car);
        return carRepository.save(dbCar);
    }


    public void delete(Long id) {
        if (!carRepository.existsById(id)) {
            throw new NotFoundException(String.format("Car with id %s does not exists", id));
        }
        carRepository.deleteById(id);
    }

    private void validateCar(BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            throw new BindingResultException(bindingResult);
        }
    }
}
