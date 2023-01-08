package org.youbooking.root.services.interfaces;

import org.youbooking.root.enums.AcceptanceStateEnum;
import org.youbooking.root.services.dtos.ReservationDto;
import org.youbooking.root.utils.StatusMapping;

import java.util.Set;

public interface ReservationServiceInterface {
    Set<ReservationDto> getAllReservations();
    ReservationDto getReservation(Long id);
    ReservationDto createReservation(ReservationDto reservationDto);
    ReservationDto updateReservation(ReservationDto reservationDto);
    ReservationDto updateReservationStatus(StatusMapping<Long, AcceptanceStateEnum> statusMapping);
    boolean deleteReservation(Long reservationId);
}
