package org.youbooking.root.services.dtos;

import lombok.Getter;
import lombok.Setter;
import org.youbooking.root.entities.Hotel;
import org.youbooking.root.entities.HotelOffer;
import org.youbooking.root.entities.Reservation;
import org.youbooking.root.enums.RoleEnum;

import java.util.Set;

@Getter @Setter
public class UserDto {
    private Long id;
    private String username;
    private String password;
    private String name;
    private String phone;
    private String cin;
    private RoleEnum role;
    private Set<HotelOffer> hotelOffers;
    private Set<Reservation> reservations;
    private Set<Hotel> createdHotels;
}