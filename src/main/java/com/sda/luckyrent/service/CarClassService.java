package com.sda.luckyrent.service;

import com.sda.luckyrent.exception.BindingResultException;
import com.sda.luckyrent.exception.NotFoundException;
import com.sda.luckyrent.model.CarClass;
import com.sda.luckyrent.repository.CarClassRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.validation.BindingResult;

import java.util.List;
import java.util.Optional;

@Service
public class CarClassService {

    @Autowired
    private CarClassRepository carClassRepository;

    public CarClass create(CarClass carClass){
        return carClassRepository.save(carClass);
    }

    public CarClass getById(Long id){
        Optional<CarClass> carClass = carClassRepository.findById(id);
        if (!carClass.isPresent()) {
            throw new NotFoundException(String.format("Car class with id %s does not exists", id));
        }
        return carClass.get();
    }

    public List<CarClass> search (String segment){
        return carClassRepository.findBySegmentContainingIgnoreCase(segment);
    }

    public CarClass update (Long id, CarClass carClass, BindingResult bindingResult){
        CarClass dbCarClass = getById(id);
        carClass.setId(id);
        validateCarClass(bindingResult);
        dbCarClass.updateFrom(carClass);
        return carClassRepository.save(dbCarClass);
    }

    public void delete(Long id){
        if (!carClassRepository.existsById(id)){
            throw new NotFoundException(String.format("Car class with id %s does not exists", id));
        }
        carClassRepository.deleteById(id);
    }

    private void validateCarClass(BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            throw new BindingResultException(bindingResult);
        }
    }

}
