package ua.foxminded.volodymyrtolpiekin.carrestservice.models;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;
import java.util.List;

@Getter
@Setter
@ToString
@RequiredArgsConstructor
@Entity
public class EVCar {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String objectId;
    @OneToOne
    @JoinColumn(name = "model_id")
    private CarModel model;
    private int year;
    @OneToOne
    @JoinColumn(name = "body_id")
    private Body body;
    @OneToOne
    @JoinColumn(name = "maker_id")
    private Maker maker;
    @OneToOne
    @JoinColumn(name = "engine_id")
    private ElectricMotor engine;
    @OneToOne
    @JoinColumn(name = "battery_id")
    private TractionBattery battery;
    @OneToOne
    @JoinColumn(name = "reducer_id")
    private Reducer reducer;
    @OneToOne
    @JoinColumn(name = "charger_id")
    private OnBoardCharger charger;
    @OneToMany
    @JoinColumn(name = "ev_car_id")
    private List<Category> category;

    @Override
    public boolean equals(Object o) {
        boolean result;
        if (this == o) {
            result = true;
        } else if (o == null || getClass() != o.getClass()) {
            result = false;
        } else {
            EVCar evCar = (EVCar) o;
            result = id.equals(evCar.id);
        }
        return result;
    }

    @Override
    public int hashCode() {
        int result = 17;
        result = 37 * result + (id == null ? 0 : id.hashCode());
        return result;
    }
}
