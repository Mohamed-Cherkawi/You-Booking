package org.youbooking.root.utils;

import org.modelmapper.ModelMapper;
import org.youbooking.root.entities.BedRoom;
import org.youbooking.root.entities.Hotel;
import org.youbooking.root.entities.HotelOffer;
import org.youbooking.root.entities.Reservation;
import org.youbooking.root.services.dtos.BedRoomDto;
import org.youbooking.root.services.dtos.HotelDto;
import org.youbooking.root.services.dtos.HotelOfferDto;
import org.youbooking.root.services.dtos.ReservationDto;

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


    public static ReservationDto reservationToReservationDto(Reservation reservation) {
        return modelMapper.map(reservation, ReservationDto.class);
    }
    public static Reservation reservationDtoToReservation(ReservationDto reservationDto) {
        return modelMapper.map(reservationDto, Reservation.class);
    }


    public static HotelOfferDto offerToOfferDto(HotelOffer hotelOffer) {
        return modelMapper.map(hotelOffer, HotelOfferDto.class);
    }
    public static HotelOffer offerDtoToOffer(HotelOfferDto hotelOfferDto) {
        return modelMapper.map(hotelOfferDto, HotelOffer.class);
    }
}
