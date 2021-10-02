package com.example.relationships.entity.oneTone;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Table(name = "capital")
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Capital {
    /*
    *   the class child
    */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long capitalId;
    private String capital;

    @OneToOne
    @JoinColumn(name = "fk_country_id")
    @MapsId // Ignora el id principal de la clase -> "capitalId" y toma la columna ->"fk_country_id"
    private Country country;
}
