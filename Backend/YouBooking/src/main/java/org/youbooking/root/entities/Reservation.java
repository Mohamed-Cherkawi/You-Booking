package org.youbooking.root.entities;

import jakarta.persistence.CascadeType;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

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
import org.youbooking.root.enums.AcceptanceStateEnum;

import java.time.LocalDate;
import java.util.Set;

@Entity @Getter @Setter @ToString
@Table(name = "reservation")
public class Reservation {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "reservation_seq")
    @SequenceGenerator(name = "reservation_seq",allocationSize = 1)
    @Column(nullable = false)
    private Long id;

    @OneToMany(cascade = {CascadeType.MERGE})
    @JoinColumn(name = "reservation_id")
    private Set<BedRoom> reservedBedRooms ;

    @Column(name = "total_price", nullable = false)
    private Float totalPrice;

    @Column(name = "start_date", nullable = false)
    private LocalDate startDate;

    @Column(name = "end_date", nullable = false)
    private LocalDate endDate;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private AcceptanceStateEnum status ;

    @ManyToOne
    @JoinColumn(name = "reserved_by", nullable = false)
    private AppUser reservedBy;

}