package org.youbooking.root.utils;

import org.modelmapper.ModelMapper;
import org.youbooking.root.entities.Hotel;
import org.youbooking.root.services.dtos.HotelDto;

public class EntityMapping {
    private static final ModelMapper modelMapper = new ModelMapper();

    private EntityMapping() {
    }

    public static HotelDto hotelToHotelDTO(Hotel hotel) {
        return modelMapper.map(hotel, HotelDto.class);
    }
    public static Hotel hotelDTOToHotel(HotelDto hotelDto) {
        return modelMapper.map(hotelDto, Hotel.class);
    }
}
