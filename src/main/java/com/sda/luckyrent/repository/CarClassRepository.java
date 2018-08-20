package com.sda.luckyrent.repository;

import com.sda.luckyrent.model.CarClass;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CarClassRepository extends JpaRepository<CarClass, Long> {

    List<CarClass> findBySegmentContainingIgnoreCase(String segment);

}
