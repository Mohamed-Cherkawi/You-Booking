package org.youbooking.root.entities;


import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import org.youbooking.root.enums.BedRoomStateEnum;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;
import java.util.Set;

@Entity @Getter @Setter @ToString @NoArgsConstructor
@Table(name = "bed_room")
public class BedRoom {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "bed_room_seq")
    @SequenceGenerator(name = "bed_room_seq", allocationSize = 1)
    @Column(nullable = false)
    private Long id;

    @Column(nullable = false, length = 30)
    private String reference;

    @OneToMany(cascade = {CascadeType.PERSIST , CascadeType.MERGE})
    private Set<Bed> beds ;

    @Column(nullable = false)
    private Float price;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private BedRoomStateEnum status;

    public BedRoom(String reference, Float price, BedRoomStateEnum status) {
        this.reference = reference;
        this.price = price;
        this.status = status;
    }
}