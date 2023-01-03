package org.youbooking.root.controllers;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.youbooking.root.services.dtos.HotelDto;
import org.youbooking.root.services.implementations.HotelService;

import java.util.Set;

@RestController
@RequestMapping("/api/hotel/manager")
public class HotelOwnerController {
    private final HotelService hotelService;

    public HotelOwnerController(@Qualifier("hotel-service") HotelService hotelService) {
        this.hotelService = hotelService;
    }

    @GetMapping("/fetching/track-id/{hotelId}")
    public ResponseEntity<HotelDto> getCreatedHotelByOwnerById(@PathVariable("hotelId") Long id){
        return ResponseEntity.ok(hotelService.getHotel(id));
    }
    @GetMapping("/fetching-all")
    public ResponseEntity<Set<HotelDto>> getAllCreatedHotelsByOwner(){
        Set<HotelDto> hotels = hotelService.getAllHotels();
        if( hotels.isEmpty() )
            return ResponseEntity.status(HttpStatus.NO_CONTENT).build();

        return ResponseEntity.ok(hotels);
    }
    @PostMapping("/add-new-hotel")
    public ResponseEntity<HotelDto> addHotelApi(@RequestBody HotelDto hotel){
        return new ResponseEntity<>(hotelService.createHotel(hotel), HttpStatus.CREATED);
    }
}
