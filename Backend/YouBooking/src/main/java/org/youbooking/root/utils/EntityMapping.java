package org.youbooking.root.utils;

import org.modelmapper.ModelMapper;
import org.youbooking.root.entities.BedRoom;
import org.youbooking.root.entities.Hotel;
import org.youbooking.root.services.dtos.BedRoomDto;
import org.youbooking.root.services.dtos.HotelDto;

public class EntityMapping {
    private static final ModelMapper modelMapper = new ModelMapper();

    private EntityMapping() {}

    public static HotelDto hotelToHotelDTO(Hotel hotel) {
        return modelMapper.map(hotel, HotelDto.class);
    }
    public static Hotel hotelDTOToHotel(HotelDto hotelDto) {
        return modelMapper.map(hotelDto, Hotel.class);
    }


    public static BedRoomDto bedRoomToBedRoomDTO(BedRoom bedRoom) {
        return modelMapper.map(bedRoom, BedRoomDto.class);
    }
    public static BedRoom bedRoomDTOToBedRoom(BedRoomDto bedRoomDto) {
        return modelMapper.map(bedRoomDto, BedRoom.class);
    }
}
