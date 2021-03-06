package com.sda.luckyrent.repository;

import com.sda.luckyrent.model.Car;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CarRepository extends JpaRepository<Car,Long > {

    List<Car> findByBrandContaining(String brand);
    List<Car> findByBrandContainingIgnoreCaseAndModelContainingIgnoreCaseAndPriceGreaterThanEqualAndPriceLessThanEqual(String brand, String model, Integer minPrice, Integer maxPrice);
}
