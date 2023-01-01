package org.youbooking.root.entities;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.Setter;
import org.youbooking.root.enums.HotelOfferStateEnum;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import java.time.LocalDateTime;

@Getter
@Setter
@Entity
@Table(name = "hotel_offer")
public class HotelOffer {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "hotel_offer_seq")
    @SequenceGenerator(name = "hotel_offer_seq", allocationSize = 1)
    @Column(name = "id", nullable = false)
    private Long id;

    @Column(nullable = false, length = 50)
    private String title;

    @Column(nullable = false)
    private String description;

    @Setter(AccessLevel.NONE)
    @Column(name = "creation_date", nullable = false)
    private LocalDateTime creationDate;

    @Enumerated(EnumType.STRING)
    private HotelOfferStateEnum status;

}