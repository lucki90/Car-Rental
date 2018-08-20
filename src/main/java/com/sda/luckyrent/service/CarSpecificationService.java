package com.sda.luckyrent.service;

import com.sda.luckyrent.exception.BindingResultException;
import com.sda.luckyrent.exception.NotFoundException;
import com.sda.luckyrent.model.CarSpecification;
import com.sda.luckyrent.repository.CarSpecificationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.validation.BindingResult;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@Service
public class CarSpecificationService {

    @Autowired
    private CarSpecificationRepository carSpecificationRepository;

    public CarSpecification create(CarSpecification carSpecification) {
        return carSpecificationRepository.save(carSpecification);
    }

    public CarSpecification getById(Long id) {
        Optional<CarSpecification> carSpecification = carSpecificationRepository.findById(id);
        if (!carSpecification.isPresent()) {
            throw new NotFoundException(String.format("Car specification with id %s does not exists", id));
        }
        return carSpecification.get();
    }

    public List<CarSpecification> search(LocalDate fromDate, LocalDate toDate, String colour) {
        if (fromDate == null) {
            fromDate=LocalDate.of(1999,1,1);
        }
        if (toDate == null) {
            toDate=LocalDate.of(2020,1,1);
        }
        return carSpecificationRepository.findByProductionYearBetweenAndColourContaining(fromDate, toDate, colour);
    }

    public CarSpecification update(Long id, CarSpecification carSpecification, BindingResult bindingResult) {
        CarSpecification dbCarSpecification = getById(id);
        carSpecification.setId(id);
        validateCarSpecification(bindingResult);
        dbCarSpecification.updateFrom(carSpecification);
        return carSpecificationRepository.save(dbCarSpecification);
    }

    public void delete(Long id) {
        if (!carSpecificationRepository.existsById(id)) {
            throw new NotFoundException(String.format("Car specification with id %s does not exists", id));
        }
        carSpecificationRepository.deleteById(id);
    }

    private void validateCarSpecification(BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            throw new BindingResultException(bindingResult);
        }
    }
}
