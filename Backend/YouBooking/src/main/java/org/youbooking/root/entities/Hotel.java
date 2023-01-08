package org.youbooking.root.entities;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import org.youbooking.root.enums.HotelStateEnum;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;

import java.util.Set;


@Entity @Getter @Setter @ToString @NoArgsConstructor
@Table(name = "hotel")
public class Hotel{
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "hotel_seq")
    @SequenceGenerator(name = "hotel_seq")
    @Column(nullable = false)
    private Long id;

    @Column(nullable = false, length = 50)
    private String name;

    @OneToMany(
            cascade = {CascadeType.PERSIST,
                    CascadeType.REMOVE,
                    CascadeType.MERGE}
    )
    @JoinColumn(name = "hotel_id")
    private Set<BedRoom> bedRooms ;

    @OneToOne(
            cascade = {CascadeType.PERSIST ,
            CascadeType.REMOVE ,
            CascadeType.MERGE}
    )
    @JoinColumn(name = "address_id", nullable = false)
    private Address address;

    @OneToMany(cascade = CascadeType.REMOVE)
    private Set<Reservation> reservations ;

    @OneToMany(
            cascade = {CascadeType.PERSIST ,
                    CascadeType.REMOVE ,
                    CascadeType.MERGE}
    )
    @JoinColumn(name = "hotel_id")
    private Set<Attachment> attachments ;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private HotelStateEnum status;

    @Column(name = "is_approved")
    private Boolean isApproved ;

    @ManyToOne(cascade = CascadeType.PERSIST)
    @JoinColumn(name = "owner_id", nullable = false)
    private AppUser owner;

    public Hotel(String name, Set<BedRoom> bedRooms, Address address, HotelStateEnum status, AppUser owner) {
        this.name = name;
        this.bedRooms = bedRooms;
        this.address = address;
        this.status = status;
        this.owner = owner;
    }
}