package com.example.garage_backend.model;


import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;

@Entity
public class Car {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long Id;

    private String make;
    private String model;
    private int year;
    private String color;
    private String licensePlate;
    private String ownerName;

    @OneToMany(mappedBy = "car", cascade = CascadeType.ALL)
    private List<FaultNote> faultNotes = new ArrayList<>();
}
