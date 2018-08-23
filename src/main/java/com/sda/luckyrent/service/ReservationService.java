package com.sda.luckyrent.service;

import com.sda.luckyrent.exception.BindingResultException;
import com.sda.luckyrent.exception.IllegalActionException;
import com.sda.luckyrent.exception.NotFoundException;
import com.sda.luckyrent.exception.UnavailableException;
import com.sda.luckyrent.model.Reservation;
import com.sda.luckyrent.repository.ReservationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.validation.BindingResult;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Service
public class ReservationService {

    private ReservationRepository reservationRepository;

    @Autowired
    public ReservationService(ReservationRepository reservationRepository) {
        this.reservationRepository = reservationRepository;
    }

    public Reservation create(Reservation reservation) {
        checkingReservationAvailability(reservation);

        return reservationRepository.save(reservation);
    }


    public Reservation getById(Long id) {
        Optional<Reservation> reservation = reservationRepository.findById(id);
        if (!reservation.isPresent()) {
            throw new NotFoundException(String.format("Reservation with id %s does not exist", id));
        }
        return reservation.get();
    }

    public List<Reservation> getAll() {
        return reservationRepository.findAll();
    }

    public Reservation update(Long id, Reservation reservation, BindingResult bindingResult) {

        Reservation dbReservation = getById(id);
        reservation.updateIfNull(dbReservation);

        checkingReservationAvailability(reservation);
        dbReservation.updateForm(reservation);
//        reservationValidation(bindingResult);
        return reservationRepository.save(dbReservation);
    }

    public void delete(Long id) {
        if (!reservationRepository.existsById(id)) {
            throw new NotFoundException(String.format("Reservation with id %s does not exist", id));
        }
        reservationRepository.deleteById(id);
    }

    private void reservationValidation(BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            throw new BindingResultException(bindingResult);
        }
    }

    private void checkingReservationAvailability(Reservation reservation) {
        LocalDateTime fromDate = reservation.getFromDate();
        LocalDateTime toDate = reservation.getToDate();

        if (toDate.isBefore(fromDate)) {
            throw new IllegalActionException("The rental period must be earlier than the return date!");
        }
        List<Reservation> dbReservations = reservationRepository.findByCar_Id(reservation.getCar().getId());

        for (Reservation dbReservation : dbReservations) {
            LocalDateTime dbFromDate = dbReservation.getFromDate();
            LocalDateTime dbToDate = dbReservation.getToDate();
//            if (reservation.getId().equals(dbReservation.getId())) continue;
            if (dbReservation.getId().equals(reservation.getId())) continue;
            if ((!fromDate.isBefore(dbFromDate) && !fromDate.isAfter(dbToDate)) ||
                    (!toDate.isBefore(dbFromDate) && !toDate.isAfter(dbToDate)) ||
                    (fromDate.isBefore(dbFromDate) && toDate.isAfter(dbToDate)) ||
                    (fromDate.isAfter(dbFromDate) && toDate.isBefore(dbToDate))) {
                throw new UnavailableException(String.format("Car with id %s is booked between %s and %s", dbReservation.getCar().getId(), dbFromDate, dbToDate));
            }
        }
    }


}

