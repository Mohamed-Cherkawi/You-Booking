package org.youbooking.root.entities;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import org.youbooking.root.enums.BedTypeEnum;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;


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