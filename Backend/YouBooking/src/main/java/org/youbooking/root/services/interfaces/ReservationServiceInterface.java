package org.youbooking.root.services.interfaces;

import org.youbooking.root.services.dtos.ReservationDto;

import java.util.Set;

public interface ReservationServiceInterface {
    Set<ReservationDto> getAllReservations();
    ReservationDto getReservation(Long id);
    ReservationDto createReservation(ReservationDto reservationDto);
    ReservationDto updateReservation(ReservationDto reservationDto);
    boolean deleteReservation(Long reservationId);
}
