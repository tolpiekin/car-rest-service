package ua.foxminded.volodymyrtolpiekin.carrestservice.models;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;


@Getter
@Setter
@ToString
@RequiredArgsConstructor
@Entity
public class Car extends CarModel {

    @OneToOne
    private Body body;
    @ManyToOne
    private CombustionEngine engine;
    @ManyToOne
    private FuelTank tank;
    @OneToOne
    private Transmission transmission;
}
