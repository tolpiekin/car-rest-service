package ua.foxminded.volodymyrtolpiekin.carrestservice.models;

import lombok.Data;
import lombok.RequiredArgsConstructor;

import javax.persistence.*;


@Data
@RequiredArgsConstructor
@Entity
public class Car extends CarModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @OneToOne
    private CarModel model;
    private int year;

    @OneToOne
    private Body body;

    @OneToOne
    private Maker maker;

    @OneToOne
    private CombustionEngine engine;

    @OneToOne
    private FuelTank tank;

    @OneToOne
    private Transmission transmission;
}
