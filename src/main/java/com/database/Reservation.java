package com.database;

import  jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;

@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
public class Reservation {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @ManyToOne(cascade = CascadeType.MERGE)
    @JoinColumn(name = "restaurant")
    private Restaurant restaurante;

    @ManyToOne(cascade = CascadeType.MERGE)
    @JoinColumn(name = "mesa")
    private Table_Restaurant mesa;

    @ManyToOne(cascade = CascadeType.MERGE)
    @JoinColumn(name = "user")
    private User usuario;

    private LocalDateTime fechadereservacion;
    private String estado;
}
