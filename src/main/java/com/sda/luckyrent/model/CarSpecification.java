package com.sda.luckyrent.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.*;
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

    @NotBlank
    @Column
    private String bodyType;

    @PastOrPresent
    @NotNull
    @Column
    private LocalDate productionYear;

    @NotBlank
    @Column
    private String colour;

    @NotNull
    @Max(value = 10)
    @Min(value = 1)
    @Column
    private Integer seats;

    @NotNull
    @Column(name = "horse_power")
    private Integer hp;

    @NotNull
    @Column
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
