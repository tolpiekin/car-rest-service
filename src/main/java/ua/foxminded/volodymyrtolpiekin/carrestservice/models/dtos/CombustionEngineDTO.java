package ua.foxminded.volodymyrtolpiekin.carrestservice.models.dtos;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class CombustionEngineDTO {
    private Long id;
    private String fuel;
    private int cylinders;
    private float volume;
    private int power;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        CombustionEngineDTO engine = (CombustionEngineDTO) o;
        return id.equals(engine.id);
    }

    @Override
    public int hashCode() {
        int result = 17;
        result = 37 * result + (id == null ? 0 : id.hashCode());
        return result;
    }
}
