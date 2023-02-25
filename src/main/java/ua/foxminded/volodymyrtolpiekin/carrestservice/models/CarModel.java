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
        if (this == o) return true;
        if (o == null || Hibernate.getClass(this) != Hibernate.getClass(o)) return false;
        CarModel carModel = (CarModel) o;
        return id != null && Objects.equals(id, carModel.id);
    }

    @Override
    public int hashCode() {
        return getClass().hashCode();
    }
}
