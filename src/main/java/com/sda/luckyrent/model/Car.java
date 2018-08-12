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
    @Column(nullable = false)
    private Integer price;

    @ManyToOne
    @JoinColumn(name = "id_car_class")
    private CarClass carClass;

    @ManyToOne
    @JoinColumn(name = "id_car_specification")
    private CarSpecification carSpecification;

    @OneToOne(mappedBy = "car")
    private Reservation reservation;

    public void updateFrom(Car car) {
        if (car.getBrand() != null) {
            this.brand = car.getBrand();
        }
        if (car.getModel() != null) {
            this.model= car.getModel();
        }
        if (car.getPrice() !=null){
            this.price= car.getPrice();
        }
        if (car.getCarClass() !=null){
            this.carClass = car.getCarClass();
        }
        if (car.getCarSpecification() !=null){
            this.carSpecification = car.getCarSpecification();
        }
    }
}
