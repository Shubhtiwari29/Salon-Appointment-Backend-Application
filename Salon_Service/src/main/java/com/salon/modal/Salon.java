package com.salon.modal;

import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalTime;
import java.util.List;

@Entity
@Data
public class Salon {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(nullable = false)
    private String name;

    @ElementCollection // THIS ANNOTATION WILL CREATE A SEPARATE TABLE FOR THIS FIELD.
    private List<String> images;

    @Column(nullable = false)
    private String address;

    @Column(nullable = false)
    private String phoneNumber;

    @Column(nullable = false)
    private String email;

    @Column(nullable = false)
    private String city;

    @Column(nullable = false)
    private Long ownerId;

    @Column(nullable = false)
    private LocalTime openTime;

    @Column(nullable = false)
    private LocalTime closeTime;
}

//@DATA -> HAS ALL OF THESE -> GETTERS, SETTERS, NO-ARG CONSTRUCTORS, ALL-ARG CONSTRUCTORS here's my SalonDTO -> package com.salon.payload.dto;

