package com.sda.luckyrent.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "reservation")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Reservation {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "reserved_from", nullable = false)
    private LocalDateTime fromDate;
    @Column(name = "reserved_to", nullable = false)
    private LocalDateTime toDate;

    @OneToOne
    @JoinColumn(name = "id_car", nullable = false)
    private Car car;

    @ManyToOne
    @JoinColumn(name = "id_user", nullable = false)
    private User user;

}
