package com.sda.luckyrent.repository;

import com.sda.luckyrent.model.CarSpecification;
import org.apache.tomcat.jni.Local;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;

@Repository
public interface CarSpecificationRepository extends JpaRepository<CarSpecification, Long> {

    List<CarSpecification> findByProductionYearBetweenAndColourContaining(LocalDate fromDate, LocalDate toDate, String colour);

}
