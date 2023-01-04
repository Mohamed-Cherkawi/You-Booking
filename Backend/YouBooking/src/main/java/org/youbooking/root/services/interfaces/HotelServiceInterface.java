package org.youbooking.root.services.interfaces;

import org.youbooking.root.services.dtos.HotelDto;

import java.util.Set;

public interface HotelServiceInterface {
    Set<HotelDto> getAllHotels();
    HotelDto getHotel(Long id);
    HotelDto createHotel(HotelDto hotel);
    HotelDto updateHotel(Long id ,HotelDto hotelDto);
    void deleteHotel(Long hotelId);
}
