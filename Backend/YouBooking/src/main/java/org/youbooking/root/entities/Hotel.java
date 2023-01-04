package org.youbooking.root.entities;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import org.youbooking.root.enums.HotelStateEnum;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import java.util.LinkedHashSet;
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

    @OneToMany(cascade = {CascadeType.PERSIST, CascadeType.REMOVE,CascadeType.MERGE})
    @JoinColumn(name = "hotel_id")
    @ToString.Exclude
    private Set<BedRoom> bedRooms = new LinkedHashSet<>();

    @OneToOne(cascade = {CascadeType.PERSIST , CascadeType.REMOVE , CascadeType.MERGE}, optional = false)
    @JoinColumn(name = "address_id", nullable = false)
    private Address address;

    @OneToMany(cascade = {CascadeType.PERSIST , CascadeType.REMOVE , CascadeType.MERGE})
    @JoinColumn(name = "hotel_id")
    @ToString.Exclude
    private Set<Attachment> attachments ;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private HotelStateEnum status;

    @Column(name = "is_approved")
    private Boolean isApproved = null;

    @ManyToOne(optional = false , cascade = CascadeType.PERSIST)
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