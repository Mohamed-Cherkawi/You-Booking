package org.youbooking.root.services.dtos;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.youbooking.root.entities.AppUser;
import org.youbooking.root.entities.Hotel;

import java.time.LocalDate;
import java.util.Set;

@Getter @Setter @ToString
public class ReservationDto {

    private Long id;
    private Set<BedRoomDto> reservedBedRooms;
    private Float totalPrice;
    private LocalDate startDate;
    private LocalDate endDate;
    private AppUser reservedBy;
    private Hotel hotel;
}
