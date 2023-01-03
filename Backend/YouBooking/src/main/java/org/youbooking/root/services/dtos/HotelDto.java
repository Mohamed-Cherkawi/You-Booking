package org.youbooking.root.services.dtos;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.youbooking.root.entities.Address;
import org.youbooking.root.entities.AppUser;
import org.youbooking.root.entities.Attachment;
import org.youbooking.root.entities.BedRoom;
import org.youbooking.root.enums.HotelStateEnum;

import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import java.util.Set;

@Getter @Setter @AllArgsConstructor @NoArgsConstructor
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
