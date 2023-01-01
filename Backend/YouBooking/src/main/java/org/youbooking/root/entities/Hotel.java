package org.youbooking.root.entities;

import lombok.Getter;
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
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import java.util.LinkedHashSet;
import java.util.Set;


@Entity @Getter @Setter @ToString
@Table(name = "hotel")
public class Hotel {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "hotel_seq")
    @SequenceGenerator(name = "hotel_seq")
    @Column(name = "id", nullable = false)
    private Long id;

    @Column(nullable = false, length = 50)
    private String name;

    @ToString.Exclude
    @OneToMany(cascade = CascadeType.PERSIST)
    @JoinColumn(name = "hotel_id")
    private Set<BedRoom> bedRooms = new LinkedHashSet<>();

    @ToString.Exclude
    @OneToOne(cascade = CascadeType.PERSIST, optional = false)
    @JoinColumn(name = "address_id", nullable = false)
    private Address address;

    @ToString.Exclude
    @OneToMany(cascade = CascadeType.PERSIST)
    @JoinColumn(name = "hotel_id")
    private Set<Attachment> attachments = new LinkedHashSet<>();

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private HotelStateEnum status;

    @Column(name = "is_approved")
    private Boolean isApproved;

}