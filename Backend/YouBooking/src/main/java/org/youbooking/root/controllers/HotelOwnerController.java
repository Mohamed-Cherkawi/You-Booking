package org.youbooking.root.controllers;

import org.springframework.beans.factory.annotation.Qualifier;
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
import org.youbooking.root.services.dtos.HotelDto;
import org.youbooking.root.services.implementations.HotelService;
import org.youbooking.root.utils.IdClassMapper;

import java.util.Set;

@RestController
@RequestMapping("/api/hotel/manager")
public class HotelOwnerController {
    private final HotelService hotelService;

    public HotelOwnerController(@Qualifier("hotel-service") HotelService hotelService) {
        this.hotelService = hotelService;
    }

    @GetMapping("/fetching/track-id/{hotelId}")
    public ResponseEntity<HotelDto> getCreatedHotelByOwnerByIdApi(@PathVariable("hotelId") Long id){
        HotelDto hotel = hotelService.getHotel(id);

        return (hotel == null) ? ResponseEntity.status(HttpStatus.GONE).build() : ResponseEntity.ok(hotel);
    }
    @GetMapping("/fetching-all")
    public ResponseEntity<Set<HotelDto>> getAllCreatedHotelsByOwnerApi(){
        Set<HotelDto> hotels = hotelService.getAllHotels();

        return (hotels.isEmpty()) ? ResponseEntity.status(HttpStatus.NO_CONTENT).build() : ResponseEntity.ok(hotels);
    }
    @PostMapping("/adding-new")
    public ResponseEntity<HotelDto> addHotelCreatedByOwnerApi(@RequestBody HotelDto hotel){
        return new ResponseEntity<>(hotelService.createHotel(hotel), HttpStatus.CREATED);
    }
    @PutMapping("/updating")
    public ResponseEntity<Object> updateHotelCreatedByOwnerByIdApi(@RequestBody HotelDto hotelDto){
        HotelDto hotel = hotelService.updateHotel(hotelDto);

        return (hotel == null) ? ResponseEntity.status(HttpStatus.GONE).body("Can't update the hotel with the id : " + hotelDto.getId() + " because it was not found ")
                : ResponseEntity.ok(hotel);
    }
    @DeleteMapping("/deleting")
    public ResponseEntity<String> deleteHotelCreatedByOwnerApi(@RequestBody IdClassMapper<Long> idClassMapper){
        if( hotelService.deleteHotel(idClassMapper.getId()) )
            return ResponseEntity.ok("The Hotel With the id " + idClassMapper.getId() + " was deleted successfully");

        return ResponseEntity.ok("The Hotel With the id " + idClassMapper.getId() + " was not found !");
    }
}
