package com.sda.luckyrent.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.List;

@Entity
@Table(name = "car_specification")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class CarSpecification {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(nullable = false)
    private String bodyType;
    @Column(nullable = false)
    private LocalDate productionYear;
    @Column(nullable = false)
    private String colour;
    @Column(nullable = false)
    private Integer seats;
    @Column(name = "horse_power", nullable = false)
    private Integer hp;
    @Column(nullable = false)
    private Double engineCapacity;

    public void updateFrom(CarSpecification carSpecification) {
        if (carSpecification.getBodyType() != null) {
            this.bodyType = carSpecification.getBodyType();
        }
        if (carSpecification.getProductionYear() != null) {
            this.productionYear = carSpecification.getProductionYear();
        }
        if (carSpecification.getColour() != null) {
            this.colour = carSpecification.getColour();
        }
        if (carSpecification.getColour() != null) {
            this.colour = carSpecification.getColour();
        }
        if (carSpecification.getSeats() != null) {
            this.seats = carSpecification.getSeats();
        }
        if (carSpecification.getHp() != null) {
            this.hp = carSpecification.getHp();
        }
        if (carSpecification.getEngineCapacity() != null) {
            this.engineCapacity = carSpecification.getEngineCapacity();
        }
    }
}
