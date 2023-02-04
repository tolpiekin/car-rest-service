package ua.foxminded.volodymyrtolpiekin.carrestservice.models;

import lombok.Data;
import lombok.RequiredArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;


@Data
@RequiredArgsConstructor
@Entity
public class Car extends CarModel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private CarModel model;
    private int year;
    private Body body;
    private Maker maker;
    private CombustionEngine engine;
    private FuelTank tank;
    private Transmission transmission;
}
