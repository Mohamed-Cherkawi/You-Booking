package org.youbooking.root.services.dtos;

import lombok.Getter;
import lombok.Setter;
import org.youbooking.root.entities.Bed;
import org.youbooking.root.enums.BedRoomStateEnum;

import java.util.Set;

@Getter @Setter
public class BedRoomDto {
    private Long id;
    private String reference;
    private Set<Bed> beds;
    private Float price;
    private BedRoomStateEnum status;
}
