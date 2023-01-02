package org.youbooking.root.entities;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import org.youbooking.root.enums.AvailabilityStateEnum;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.Id;
import java.util.Set;


@Entity @Getter @Setter @ToString @NoArgsConstructor
@Table(name = "app_user")
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

    @ManyToMany(cascade = CascadeType.PERSIST)
    @JoinTable(name = "user_role",
            joinColumns = @JoinColumn(name = "user_id"),
            inverseJoinColumns = @JoinColumn(name = "role_id"))
    @ToString.Exclude
    private Set<Role> roles ;

    @OneToMany(mappedBy = "user", cascade = CascadeType.PERSIST)
    @ToString.Exclude
    private Set<HotelOffer> hotelOffers = null;

    @OneToMany(mappedBy = "reservedBy", cascade = CascadeType.PERSIST)
    @ToString.Exclude
    private Set<Reservation> reservations = null;

    @OneToMany(mappedBy = "owner", cascade = CascadeType.PERSIST)
    @ToString.Exclude
    private Set<Hotel> createdHotels = null;

    public AppUser(String username, String password, String name, String phone, String cin, Set<Role> roles) {
        this.username = username;
        this.password = password;
        this.name = name;
        this.phone = phone;
        this.cin = cin;
        this.roles = roles;
    }
}