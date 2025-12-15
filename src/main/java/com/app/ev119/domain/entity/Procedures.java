package com.app.ev119.domain.entity;

import jakarta.persistence.*;
import lombok.*;

@Getter @Setter
@ToString
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@NoArgsConstructor @AllArgsConstructor
@Entity @Table(name = "TBL_PROCEDURES")
@SequenceGenerator(
        name = "SEQ_PROCEDURES_GENERATOR",
        sequenceName = "SEQ_PROCEDURES",
        allocationSize = 1
)
public class Procedures {
    @Id @EqualsAndHashCode.Include
    @GeneratedValue(strategy = GenerationType.AUTO, generator = "SEQ_PROCEDURES_GENERATOR")
    private Long id;
    private String diseaseName;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "FIRST_AID_ID")
    private FirstAid firstAid;

}
