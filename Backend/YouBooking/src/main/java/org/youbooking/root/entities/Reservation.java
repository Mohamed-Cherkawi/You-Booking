package org.youbooking.root.entities;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;
import java.time.LocalDateTime;
import java.util.LinkedHashSet;
import java.util.Set;

@Entity @Getter @Setter @ToString
@Table(name = "reservation")
public class Reservation {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "reservation_seq")
    @SequenceGenerator(name = "reservation_seq",allocationSize = 1)
    @Column(nullable = false)
    private Long id;

    @ToString.Exclude
    @OneToMany(cascade = CascadeType.PERSIST)
    @JoinColumn(name = "reservation_id")
    private Set<BedRoom> reservedBedRooms = new LinkedHashSet<>();

    @Column(name = "total_price", nullable = false)
    private Float totalPrice;

    @Column(name = "start_date", nullable = false)
    private LocalDateTime startDate;

    @Column(name = "end_date", nullable = false)
    private LocalDateTime endDate;

    @ManyToOne(optional = false)
    @JoinColumn(name = "reserved_by", nullable = false)
    private AppUser reservedBy;

}