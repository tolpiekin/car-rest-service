package ua.foxminded.volodymyrtolpiekin.carrestservice.models;

import lombok.*;
import org.hibernate.Hibernate;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.util.Objects;

@Getter
@Setter
@ToString
@RequiredArgsConstructor
@Entity
public class FuelTank {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private int volume;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || Hibernate.getClass(this) != Hibernate.getClass(o)) return false;
        FuelTank fuelTank = (FuelTank) o;
        return id != null && Objects.equals(id, fuelTank.id);
    }

    @Override
    public int hashCode() {
        return getClass().hashCode();
    }
}
