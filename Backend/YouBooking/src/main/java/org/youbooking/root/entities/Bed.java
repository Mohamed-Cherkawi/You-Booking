package org.youbooking.root.entities;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import org.youbooking.root.enums.BedTypeEnum;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;


@Entity @Setter @Getter @ToString @NoArgsConstructor
@Table(name = "bed")
public class Bed {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "bed_seq")
    @SequenceGenerator(name = "bed_seq")
    @Column(name = "id", nullable = false)
    private Integer id;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private BedTypeEnum type;

    public Bed(BedTypeEnum type) {
        this.type = type;
    }
}