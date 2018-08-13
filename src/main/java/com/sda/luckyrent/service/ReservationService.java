package com.sda.luckyrent.service;

import com.sda.luckyrent.exception.BindingResultException;
import com.sda.luckyrent.exception.NotFoundException;
import com.sda.luckyrent.model.Reservation;
import com.sda.luckyrent.repository.ReservationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.validation.BindingResult;

import java.util.List;
import java.util.Optional;

@Service
public class ReservationService {

    @Autowired
    private ReservationRepository reservationRepository;

    public Reservation create(Reservation reservation) {
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
        reservation.setId(id);
        reservationValidation(bindingResult);
        dbReservation.updateForm(reservation);
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
}

