package org.youbooking.root.services.dtos;

import lombok.Getter;
import lombok.Setter;
import org.youbooking.root.enums.AvailabilityStateEnum;

import java.time.LocalDateTime;

@Getter @Setter
public class HotelOfferDto {
    Long id;
    String title;
    private String description;
    private LocalDateTime creationDate;
    private AvailabilityStateEnum status;
    private HotelDto hotel ;
}
