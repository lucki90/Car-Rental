package com.sda.luckyrent.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@Entity
@Table(name = "Car")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Car {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank
    @Column(name = "car_brand")
    private String brand;

    @NotBlank
    @Column(name = "car_model")
    private String model;

    @NotBlank
    @Max(value = 10000)
    @Min(value = 10)
    @Column
    private Integer price;

    @NotNull
    @ManyToOne
    @JoinColumn(name = "id_car_class")
    private CarClass carClass;

    @NotNull
    @ManyToOne
    @JoinColumn(name = "id_car_specification")
    private CarSpecification carSpecification;

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
