package com.sda.luckyrent.model;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "car_class")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class CarClass {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(unique = true, nullable = false)
    private String segment;
    @Column(nullable = false)
    private String segmentDescription;

    public void updateFrom(CarClass carClass) {
        if (carClass.getSegment() != null) {
            this.segment = carClass.getSegment();
        }
        if (carClass.getSegmentDescription() != null) {
            this.segmentDescription = carClass.getSegmentDescription();
        }
    }

//    @OneToMany(mappedBy = "carClass")
//    private List<Car> cars;

}