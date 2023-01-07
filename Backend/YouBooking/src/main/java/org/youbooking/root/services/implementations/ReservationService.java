package org.youbooking.root.services.implementations;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.youbooking.root.entities.BedRoom;
import org.youbooking.root.entities.Reservation;
import org.youbooking.root.enums.BedRoomStateEnum;
import org.youbooking.root.repositories.BedRoomRepository;
import org.youbooking.root.repositories.ReservationRepository;
import org.youbooking.root.services.dtos.ReservationDto;
import org.youbooking.root.services.interfaces.ReservationServiceInterface;
import org.youbooking.root.utils.EntityMapping;

import java.util.List;
import java.util.Optional;
import java.util.Set;
import java.util.stream.Collectors;

@Service("reservation-service") @RequiredArgsConstructor
public class ReservationService implements ReservationServiceInterface {
    private final ReservationRepository reservationRepository;
    private final BedRoomRepository bedRoomRepository;


    @Override // TODO: Pageable
    public Set<ReservationDto> getAllReservations() {
        List<Reservation> reservations = reservationRepository.findAll();
        return reservations.stream()
                .map(EntityMapping::reservationToReservationDto)
                .collect(Collectors.toSet());
    }

    @Override
    public ReservationDto getReservation(Long id) {
        Optional<Reservation> reservationOptional = reservationRepository.findById(id);
        return reservationOptional.map(EntityMapping::reservationToReservationDto)
                .orElse(null);
    }

    @Override @Transactional
    public ReservationDto createReservation(ReservationDto reservationDto) {
        reservationDto.getReservedBedRooms().stream()
                .map(bedRoom -> bedRoomRepository.findById(bedRoom.getId()).orElseThrow())
                .forEach(bedRoom -> {
                    bedRoom.setStatus(BedRoomStateEnum.RESERVED);
                    bedRoomRepository.save(bedRoom);
                });

        Reservation reservation = EntityMapping.reservationDtoToReservation(reservationDto);

        return EntityMapping.reservationToReservationDto(reservationRepository.save(reservation));
    }

    @Override @Transactional
    public ReservationDto updateReservation(ReservationDto reservationDto) {
        Optional<Reservation> reservationOptional = reservationRepository.findById(reservationDto.getId());

        if( reservationOptional.isEmpty() )
            return null;

        Set<BedRoom> bedRooms = reservationDto.getReservedBedRooms().stream()
                .map(EntityMapping::bedRoomDTOToBedRoom)
                .collect(Collectors.toSet());

        Reservation reservationToBeUpdated = reservationOptional.get();

        reservationToBeUpdated.setReservedBedRooms(bedRooms);
        reservationToBeUpdated.setTotalPrice(reservationDto.getTotalPrice());
        reservationToBeUpdated.setStartDate(reservationDto.getStartDate());
        reservationToBeUpdated.setEndDate(reservationDto.getEndDate());

        return EntityMapping.reservationToReservationDto(reservationRepository.save(reservationToBeUpdated));
    }

    @Override @Transactional
    public boolean deleteReservation(Long reservationId) {
        Optional<Reservation> reservationOptional = reservationRepository.findById(reservationId);

        if ( reservationOptional.isEmpty() )
            return false;

        reservationRepository.deleteById(reservationId);

        return true;
    }
}
