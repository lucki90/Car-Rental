package com.sda.luckyrent.model;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;

@Entity
@Table(name = "car_class")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class CarClass {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank
    @Column(unique = true)
    private String segment;

    @NotBlank
    @Column
    private String segmentDescription;

    public void updateFrom(CarClass carClass) {
        if (carClass.getSegment() != null) {
            this.segment = carClass.getSegment();
        }
        if (carClass.getSegmentDescription() != null) {
            this.segmentDescription = carClass.getSegmentDescription();
        }
    }
}