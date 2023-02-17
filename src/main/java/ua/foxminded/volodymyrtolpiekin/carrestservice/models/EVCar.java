package ua.foxminded.volodymyrtolpiekin.carrestservice.models;

import lombok.*;
import org.hibernate.Hibernate;

import javax.persistence.*;
import java.util.Objects;

@Getter
@Setter
@ToString
@RequiredArgsConstructor
@Entity
public class EVCar {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        EVCar evCar = (EVCar) o;
        return id.equals(evCar.id);
    }

    @Override
    public int hashCode() {
        int result = 17;
        result = 37 * result + (id == null ? 0 : id.hashCode());
        return result;
    }
}
