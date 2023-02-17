package ua.foxminded.volodymyrtolpiekin.carrestservice.models.dtos;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class TransmissionDTO {
    private Long id;
    private String type;
    private int gears;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        TransmissionDTO transmission = (TransmissionDTO) o;
        return id.equals(transmission.id);
    }

    @Override
    public int hashCode() {
        int result = 17;
        result = 37 * result + (id == null ? 0 : id.hashCode());
        return result;
    }
}
