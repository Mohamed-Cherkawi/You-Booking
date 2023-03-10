package org.youbooking.root.controllers;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.youbooking.root.services.dtos.ReservationDto;
import org.youbooking.root.services.interfaces.ReservationServiceInterface;
import org.youbooking.root.utils.IdClassMapper;

import java.util.Set;

@RestController @RequiredArgsConstructor
@RequestMapping("/api/reservation/client")
public class ClientController {
    private final ReservationServiceInterface reservationService;


    @GetMapping("/fetching/track-id/{reservationId}")
    public ResponseEntity<Object> getCreatedReservationByClientByIdApi(@PathVariable("reservationId") Long id) {
        ReservationDto reservation = reservationService.getReservation(id);

        return (reservation == null)
                ? ResponseEntity.status(HttpStatus.NOT_FOUND).body("Can't find the hotel with the id : " + id + "try again")
                : ResponseEntity.ok(reservation);
    }
    @GetMapping("/fetching-all")
    public ResponseEntity<Set<ReservationDto>> getAllCreatedReservationsByClientApi() {
        Set<ReservationDto> reservations = reservationService.getAllReservations();

        return (reservations.isEmpty())
                ? ResponseEntity.status(HttpStatus.NO_CONTENT).build()
                : ResponseEntity.ok(reservations);
    }
    @PostMapping("/adding-new")
    public ResponseEntity<ReservationDto> addReservationCreatedByClient(@RequestBody ReservationDto reservation) {
        return ResponseEntity.ok(reservationService.createReservation(reservation));
    }
    @PutMapping("/updating")
    public ResponseEntity<Object> updateReservationCreatedByClientIdApi(@RequestBody ReservationDto reservationDto) {
        ReservationDto reservation = reservationService.updateReservation(reservationDto);

        return (reservation == null)
                ? ResponseEntity.status(HttpStatus.NOT_FOUND).body("Can't update the reservation with the id : " + reservationDto.getId() + " because it was not found !")
                : ResponseEntity.ok(reservation);
    }
    @DeleteMapping("/deleting")
    public ResponseEntity<String> deleteReservationCreatedByClientApi(@RequestBody IdClassMapper<Long> idClassMapper) {
        return ( reservationService.deleteReservation(idClassMapper.getId()) )
                ? ResponseEntity.ok("The Reservation With the id " + idClassMapper.getId() + " was deleted successfully")
                : ResponseEntity.status(HttpStatus.NOT_FOUND).body("Can't delete the reservation with the id : " + idClassMapper.getId() + " because it was not found");
    }
}
