package org.youbooking.root.entities;


import lombok.NoArgsConstructor;
import lombok.ToString;
import org.youbooking.root.enums.BedRoomStateEnum;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import java.util.Set;

@Entity @ToString @NoArgsConstructor
@Table(name = "bed_room")
public class BedRoom {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "bed_room_seq")
    @SequenceGenerator(name = "bed_room_seq", allocationSize = 1)
    @Column(nullable = false)
    private Long id;

    @Column(nullable = false, length = 30)
    private String reference;

    @OneToMany(cascade = CascadeType.PERSIST)
    @ToString.Exclude
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

    public Long getId() {
        return id;
    }

    public String getReference() {
        return reference;
    }

    public void setReference(String reference) {
        this.reference = reference;
    }

    public Set<Bed> getBeds() {
        return beds;
    }

    public void setBeds(Set<Bed> beds) {
        this.beds = beds;
    }

    public Float getPrice() {
        return price;
    }

    public void setPrice(Float price) {
        this.price = price;
    }

    public BedRoomStateEnum getStatus() {
        return status;
    }

    public void setStatus(BedRoomStateEnum status) {
        this.status = status;
    }
}