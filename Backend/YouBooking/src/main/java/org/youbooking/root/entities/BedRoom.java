package org.youbooking.root.entities;

import lombok.Getter;
import lombok.Setter;
import org.youbooking.root.enums.BedRoomStateEnum;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Getter
@Setter
@Entity
@Table(name = "bed_room")
public class BedRoom {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "bed_room_seq")
    @SequenceGenerator(name = "bed_room_seq", allocationSize = 1)
    @Column(name = "id", nullable = false)
    private Long id;

    @Column(nullable = false, length = 30)
    private String reference;

    @Column(name = "num_of_beds", nullable = false)
    private Byte numOfBeds;

    @Column(nullable = false)
    private Float price;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private BedRoomStateEnum status;

}