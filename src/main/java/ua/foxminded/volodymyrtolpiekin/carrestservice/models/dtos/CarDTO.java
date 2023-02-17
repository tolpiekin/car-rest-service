package ua.foxminded.volodymyrtolpiekin.carrestservice.models.dtos;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class CarDTO {
    private Long id;
    private CarModelDTO model;
    private int year;
    private BodyDTO body;
    private MakerDTO maker;
    private CombustionEngineDTO engine;
    private FuelTankDTO tank;
    private TransmissionDTO transmission;
}
