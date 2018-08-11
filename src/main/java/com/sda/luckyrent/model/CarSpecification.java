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

//    @OneToMany(mappedBy = "carSpecification")
//    private List<Car> cars;

    //Dzięki tej addnotacji nie pojawia się rekurencja i stackOverFlow przy pobieraniu obiektu
//    @JsonIgnore
//    public List<Car> getCars() {
//        return cars;
//    }
}
