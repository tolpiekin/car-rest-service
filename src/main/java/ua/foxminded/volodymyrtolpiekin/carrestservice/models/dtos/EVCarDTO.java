package ua.foxminded.volodymyrtolpiekin.carrestservice.models.dtos;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class EVCarDTO {
    private Long id;
    private String objectId;
    private MakerDTO maker;
    private String name;
    private int year;
    private List<CategoryDTO> category;
    private BodyDTO body;
    private ElectricMotorDTO engine;
    private TractionBatteryDTO battery;
    private ReducerDTO reducer;
    private OnBoardChargerDTO charger;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        EVCarDTO evCarDTO = (EVCarDTO) o;
        return id.equals(evCarDTO.id);
    }

    @Override
    public int hashCode() {
        int result = 17;
        result = 37 * result + (id == null ? 0 : id.hashCode());
        return result;
    }
}
