package org.youbooking.root.entities;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import java.time.LocalDateTime;
import java.util.LinkedHashSet;
import java.util.Set;

@Entity @Getter @Setter @ToString
@Table(name = "reservation")
public class Reservation {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "reservation_seq")
    @SequenceGenerator(name = "reservation_seq",allocationSize = 1)
    @Column(name = "id", nullable = false)
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

}