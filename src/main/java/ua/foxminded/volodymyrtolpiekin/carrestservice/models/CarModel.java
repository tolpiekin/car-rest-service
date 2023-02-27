package ua.foxminded.volodymyrtolpiekin.carrestservice.models;

import com.fasterxml.jackson.annotation.JsonBackReference;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import org.hibernate.Hibernate;

import javax.persistence.*;
import java.util.List;
import java.util.Objects;

@Getter
@Setter
@ToString
@RequiredArgsConstructor
@Entity
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
public class CarModel {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String objectId;
    private String name;
    @ManyToOne
    @JoinColumn(name = "maker_id")
    @JsonBackReference
    private Maker maker;
    private int year;
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
            CarModel carModel = (CarModel) o;
            result = id != null && Objects.equals(id, carModel.id) && o.getClass() == this.getClass();
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
