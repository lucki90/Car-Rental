package com.sda.luckyrent.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Table(name = "Car")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Car {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "car_brand", nullable = false)
    private String brand;
    @Column(name = "car_model", nullable = false)
    private String model;

    @ManyToOne
    @JoinColumn(name = "id_car_class")
    private CarClass carClass;

    @ManyToOne
    @JoinColumn(name = "id_car_specification")
    private CarSpecification carSpecification;

    @OneToOne(mappedBy = "car")
    private Reservation reservation;
}
