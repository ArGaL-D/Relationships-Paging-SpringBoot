package com.example.relationships.entity.oneTone;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Table(name = "country")
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Country {
    /*
     *  Shared Primary Key JPA  - with mappedBy
     *  Bidirectional
    */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long countryId;
    private String country;

    @OneToOne(mappedBy = "country", cascade = CascadeType.ALL)
    @PrimaryKeyJoinColumn // Indicar que PK es un FK
    private Capital capital;
}
