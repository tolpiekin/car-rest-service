package ua.foxminded.volodymyrtolpiekin.carrestservice.models.dtos;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import ua.foxminded.volodymyrtolpiekin.carrestservice.models.Maker;

import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class CarModelDTO {
    private Long id;
    private String name;
    private Maker maker;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        CarModelDTO carModelDTO = (CarModelDTO) o;
        return id.equals(carModelDTO.id);
    }

    @Override
    public int hashCode() {
        int result = 17;
        result = 37 * result + (id == null ? 0 : id.hashCode());
        return result;
    }
}
