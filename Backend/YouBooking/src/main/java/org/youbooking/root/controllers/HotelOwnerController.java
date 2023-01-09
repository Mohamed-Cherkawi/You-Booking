package org.youbooking.root.controllers;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.youbooking.root.enums.AcceptanceStateEnum;
import org.youbooking.root.enums.BedRoomStateEnum;
import org.youbooking.root.services.dtos.BedRoomDto;
import org.youbooking.root.services.dtos.HotelDto;
import org.youbooking.root.services.dtos.ReservationDto;
import org.youbooking.root.services.interfaces.BedRoomServiceInterface;
import org.youbooking.root.services.interfaces.HotelServiceInterface;
import org.youbooking.root.services.interfaces.ReservationServiceInterface;
import org.youbooking.root.utils.IdClassMapper;
import org.youbooking.root.utils.StatusMapping;

import java.util.Set;


@RestController @RequiredArgsConstructor
@RequestMapping("/api/hotel/manager")
public class HotelOwnerController {
    private final HotelServiceInterface hotelService;
    private final BedRoomServiceInterface bedRoomService;
    private final ReservationServiceInterface reservationService;


    @GetMapping("/fetching/track-id/{hotelId}")
    public ResponseEntity<Object> getCreatedHotelByOwnerByIdApi(@PathVariable("hotelId") Long id){
        HotelDto hotel = hotelService.getHotel(id);

        return (hotel == null)
                ? ResponseEntity.status(HttpStatus.NOT_FOUND).body("Can't find the hotel with the id : "+ id + " try again")
                : ResponseEntity.ok(hotel);
    }
    @GetMapping("/fetching-all")
    public ResponseEntity<Set<HotelDto>> getAllCreatedHotelsByOwnerApi(){
        Set<HotelDto> hotels = hotelService.getAllHotels();

        return (hotels.isEmpty())
                ? ResponseEntity.status(HttpStatus.NO_CONTENT).build()
                : ResponseEntity.ok(hotels);
    }
    @PostMapping("/adding-new")
    public ResponseEntity<HotelDto> addHotelCreatedByOwnerApi(@RequestBody HotelDto hotel){
        return ResponseEntity.ok(hotelService.createHotel(hotel));
    }
    @PutMapping("/updating")
    public ResponseEntity<Object> updateHotelCreatedByOwnerIdApi(@RequestBody HotelDto hotelDto){
        HotelDto hotel = hotelService.updateHotel(hotelDto);

        return (hotel == null)
                ? ResponseEntity.status(HttpStatus.NOT_FOUND).body("Can't update the hotel with the id : " + hotelDto.getId() + " because it was not found ")
                : ResponseEntity.ok(hotel);
    }
    @PatchMapping("/updating-bed-room-status")
    public ResponseEntity<Object> updateBedRoomAvailabilityStatusApi(@RequestBody StatusMapping<Long, BedRoomStateEnum> statusMapping){
        BedRoomDto bedRoom = bedRoomService.updateStatus(statusMapping);

        return (bedRoom == null)
                ? ResponseEntity.status(HttpStatus.NOT_FOUND).body("Can't update the status of the bed room with the id : " + statusMapping.getId() + " because it was not found !")
                : ResponseEntity.ok(bedRoom);
    }
    @PatchMapping("/updating-reservation-status")
    public ResponseEntity<Object> updateReservationAcceptanceStatusApi(@RequestBody StatusMapping<Long, AcceptanceStateEnum> statusMapping){
        ReservationDto reservation = reservationService.updateReservationStatus(statusMapping);

        return (reservation == null)
                ? ResponseEntity.status(HttpStatus.NOT_FOUND).body("Can't update the status of the reservation with the id : " + statusMapping.getId() + " because it was not found !")
                : ResponseEntity.ok(reservation);
    }
    @DeleteMapping("/deleting")
    public ResponseEntity<String> deleteHotelCreatedByOwnerApi(@RequestBody IdClassMapper<Long> idClassMapper){
            return ( hotelService.deleteHotel(idClassMapper.getId()) )
                    ? ResponseEntity.ok("The Hotel With the id " + idClassMapper.getId() + " was deleted successfully")
                    : ResponseEntity.status(HttpStatus.NOT_FOUND).body("The Hotel With the id " + idClassMapper.getId() + " was not found !");
    }
}
