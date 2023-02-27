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
public class EVCar extends CarModel {
    @OneToOne
    private Body body;
    @ManyToOne
    private ElectricMotor engine;
    @ManyToOne
    private TractionBattery battery;
    @ManyToOne
    private Reducer reducer;
    @ManyToOne
    private OnBoardCharger charger;
}
