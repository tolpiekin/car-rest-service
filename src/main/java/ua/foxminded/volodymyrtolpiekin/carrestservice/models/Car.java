package ua.foxminded.volodymyrtolpiekin.carrestservice.models;

import lombok.*;
import org.hibernate.Hibernate;

import javax.persistence.*;
import java.util.List;
import java.util.Objects;


@Getter
@Setter
@ToString
@RequiredArgsConstructor
@Entity
public class Car extends CarModel {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String objectId;

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

    @OneToMany
    @JoinColumn(name = "car_id")
    private List<Category> category;

    @Override
    public boolean equals(Object o) {
        boolean result;
        if (this == o) {
            result = true;
        } else if (o == null || Hibernate.getClass(this) != Hibernate.getClass(o)) {
            result = false;
        } else {
            Car car = (Car) o;
            result = id != null && Objects.equals(id, car.id) && o.getClass() == this.getClass();
        }
        return result;
    }

    @Override
    public int hashCode() {
        return getClass().hashCode();
    }
}
