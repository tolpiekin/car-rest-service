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
public class Body {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String color;

    @Override
    public boolean equals(Object o) {
        boolean result;
        if (this == o) {
            result = true;
        } else if (o == null || Hibernate.getClass(this) != Hibernate.getClass(o)) {
            result = false;
        } else {
            Body body = (Body) o;
            result = id != null && Objects.equals(id, body.id) && o.getClass() == this.getClass();
        }
        return result;
    }

    @Override
    public int hashCode() {
        return getClass().hashCode();
    }
}
