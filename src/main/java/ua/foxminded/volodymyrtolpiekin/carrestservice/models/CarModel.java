package ua.foxminded.volodymyrtolpiekin.carrestservice.models;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import org.hibernate.Hibernate;

import javax.persistence.*;
import java.util.Objects;

@Getter
@Setter
@ToString
@RequiredArgsConstructor
@Entity
public class CarModel {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String name;
    @ManyToOne
    @JoinColumn(name = "maker_id")
    private Maker maker;

    @Override
    public boolean equals(Object o) {
        boolean result;
        if (this == o) {
            result = true;
        } else if (o == null || Hibernate.getClass(this) != Hibernate.getClass(o)) {
            result = false;
        } else {
            CarModel carModel = (CarModel) o;
            result = id != null && Objects.equals(id, carModel.id) && o.getClass() == this.getClass();
        }
        return result;
    }

    @Override
    public int hashCode() {
        return getClass().hashCode();
    }
}
