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
    private Maker maker;

    @OneToMany
    @ToString.Exclude
    private List<Category> category;

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
