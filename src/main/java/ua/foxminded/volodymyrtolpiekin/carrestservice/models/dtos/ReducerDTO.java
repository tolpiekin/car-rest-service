package ua.foxminded.volodymyrtolpiekin.carrestservice.models.dtos;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ReducerDTO {
    private Long id;
    private String ratio;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ReducerDTO reducerDTO = (ReducerDTO) o;
        return id.equals(reducerDTO.id);
    }

    @Override
    public int hashCode() {
        int result = 17;
        result = 37 * result + (id == null ? 0 : id.hashCode());
        return result;
    }
}
