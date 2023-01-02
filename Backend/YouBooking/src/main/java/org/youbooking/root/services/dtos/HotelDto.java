package org.youbooking.root.services.dtos;

import lombok.Getter;
import lombok.Setter;
import org.youbooking.root.entities.Address;
import org.youbooking.root.entities.AppUser;
import org.youbooking.root.entities.Attachment;
import org.youbooking.root.entities.BedRoom;
import org.youbooking.root.enums.HotelStateEnum;

import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.Transient;
import java.util.Set;

@Getter @Setter
public class HotelDto  {
    private Long id;
    private String name;
    @Transient
    private Set<BedRoom> bedRooms ;
    private Address address;
    @Transient
    private Set<Attachment> attachments ;

    @Enumerated(EnumType.STRING)
    private HotelStateEnum status;
    private Boolean isApproved;
    @Transient
    private AppUser owner;
}
