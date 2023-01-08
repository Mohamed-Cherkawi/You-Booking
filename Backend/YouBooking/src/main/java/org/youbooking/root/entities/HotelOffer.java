package org.youbooking.root.entities;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.youbooking.root.enums.AcceptanceStateEnum;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;
import java.time.LocalDateTime;

@Entity @Getter @Setter @ToString
@Table(name = "hotel_offer")
public class HotelOffer {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "hotel_offer_seq")
    @SequenceGenerator(name = "hotel_offer_seq", allocationSize = 1)
    @Column(nullable = false)
    private Long id;

    @Column(nullable = false, length = 50)
    private String title;

    @Column(nullable = false)
    private String description;

    @Setter(AccessLevel.NONE)
    @Column(name = "creation_date", nullable = false)
    private LocalDateTime creationDate;

    @Enumerated(EnumType.STRING)
    private AcceptanceStateEnum status;

}