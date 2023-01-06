package org.youbooking.root.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import org.youbooking.root.enums.AvailabilityStateEnum;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import jakarta.persistence.Id;
import java.util.Set;


@Entity @Getter @Setter @ToString @NoArgsConstructor
@Table(name = "_user")
public class AppUser {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "app_user_seq")
    @SequenceGenerator(name = "app_user_seq",allocationSize = 1)
    @Column(nullable = false)
    private Long id;

    @Column( nullable = false, length = 50)
    private String username;

    @Column( nullable = false, length = 100)
    private String password;

    @Column(length = 50)
    private String name;

    @Column(length = 50)
    private String phone;

    @Column(length = 30)
    private String cin;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private AvailabilityStateEnum status = AvailabilityStateEnum.ONLINE;

    @ManyToOne
    @JoinColumn(name = "role_id", nullable = false)
    private Role role;

    @OneToMany(cascade = CascadeType.PERSIST)
    @ToString.Exclude
    @JsonIgnore
    private Set<HotelOffer> hotelOffers = null;

    @OneToMany(mappedBy = "reservedBy", cascade = CascadeType.PERSIST , fetch = FetchType.LAZY)
    @ToString.Exclude
    @JsonIgnore
    private Set<Reservation> reservations = null;

    @OneToMany(mappedBy = "owner", cascade = CascadeType.PERSIST,fetch = FetchType.LAZY)
    @ToString.Exclude
    @JsonIgnore
    private Set<Hotel> createdHotels = null;

    public AppUser(String username, String password, String name, String phone, String cin, Role role) {
        this.username = username;
        this.password = password;
        this.name = name;
        this.phone = phone;
        this.cin = cin;
        this.role = role;
    }

}