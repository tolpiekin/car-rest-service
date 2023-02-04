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
}
