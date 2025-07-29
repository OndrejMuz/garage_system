package com.example.garage_backend.model;


import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
@Entity
public class FaultNote {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String description;
    private LocalDate createdAt;
    private boolean isRepaired = false;

    @ManyToOne
    @JoinColumn(name = "car_id")
    private Car car;
}
