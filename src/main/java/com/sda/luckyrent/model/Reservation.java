package com.sda.luckyrent.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.Future;
import javax.validation.constraints.FutureOrPresent;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
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

    @NotNull
    @FutureOrPresent
    @Column(name = "reserved_from")
    private LocalDateTime fromDate;

    @NotNull
    @Future
    @Column(name = "reserved_to")
    private LocalDateTime toDate;

    @NotNull
    @ManyToOne
    @JoinColumn(name = "id_car")
    private Car car;

    @NotNull
    @ManyToOne
    @JoinColumn(name = "id_user")
    private User user;

    public void updateForm(Reservation reservation) {
        if (reservation.getFromDate() != null) {
            this.fromDate = reservation.getFromDate();
        }
        if (reservation.getToDate() != null){
            this.toDate = reservation.getToDate();
        }
        if (reservation.getCar() != null){
            this.car = reservation.getCar();
        }
        if (reservation.getUser() != null){
            this.user = reservation.getUser();
        }
    }
    public void updateIfNull(Reservation reservation){
        if (this.getId()==null){
            this.id = reservation.getId();
        }
        if (this.getFromDate() == null) {
            this.fromDate = reservation.getFromDate();
        }
        if (this.getToDate() == null){
            this.toDate = reservation.getToDate();
        }
        if (this.getCar() == null){
            this.car = reservation.getCar();
        }
        if (this.getUser() == null){
            this.user = reservation.getUser();
        }

    }
}
