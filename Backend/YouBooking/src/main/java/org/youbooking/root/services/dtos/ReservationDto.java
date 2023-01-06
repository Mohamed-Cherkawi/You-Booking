package org.youbooking.root.services.dtos;

import lombok.Getter;
import lombok.Setter;
import org.youbooking.root.entities.AppUser;
import org.youbooking.root.entities.BedRoom;

import java.time.LocalDateTime;
import java.util.Set;

@Getter @Setter
public class ReservationDto {

    private Long id;
    private Set<BedRoom> reservedBedRooms;
    private Float totalPrice;
    private LocalDateTime startDate;
    private LocalDateTime endDate;
    private AppUser reservedBy;
}
