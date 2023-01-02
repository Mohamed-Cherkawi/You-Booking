package org.youbooking.root.controllers;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.youbooking.root.services.dtos.HotelDto;
import org.youbooking.root.services.implementations.HotelService;

@RestController
@RequestMapping("/api/hotel/manager")
public class HotelController {
    private final HotelService hotelService;

    public HotelController(@Qualifier("hotel-service") HotelService hotelService) {
        this.hotelService = hotelService;
    }

    @PostMapping("/add-new-hotel")
    public ResponseEntity<HotelDto> addHotelApi(@RequestBody HotelDto hotel){
        return new ResponseEntity<>(hotelService.createHotel(hotel), HttpStatus.CREATED);
    }
}
