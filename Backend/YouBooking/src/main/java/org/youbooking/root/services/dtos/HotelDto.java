package org.youbooking.root.services.dtos;

import lombok.Getter;
import lombok.Setter;
import org.youbooking.root.entities.Address;
import org.youbooking.root.entities.AppUser;
import org.youbooking.root.entities.Attachment;
import org.youbooking.root.entities.BedRoom;
import org.youbooking.root.enums.HotelStateEnum;

import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import java.util.Set;

@Getter @Setter
public class HotelDto  {
    private Long id;
    private String name;
    private Set<BedRoom> bedRooms ;
    private Address address;
    private Set<Attachment> attachments ;
    @Enumerated(EnumType.STRING)
    private HotelStateEnum status;
    private Boolean isApproved = null;
    private AppUser owner;
}