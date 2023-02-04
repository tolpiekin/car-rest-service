package ua.foxminded.volodymyrtolpiekin.carrestservice.models.dtos;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import ua.foxminded.volodymyrtolpiekin.carrestservice.models.Body;
import ua.foxminded.volodymyrtolpiekin.carrestservice.models.CarModel;
import ua.foxminded.volodymyrtolpiekin.carrestservice.models.CombustionEngine;
import ua.foxminded.volodymyrtolpiekin.carrestservice.models.FuelTank;
import ua.foxminded.volodymyrtolpiekin.carrestservice.models.Maker;
import ua.foxminded.volodymyrtolpiekin.carrestservice.models.Transmission;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class CarDTO {
    private Long id;
    private CarModel model;
    private int year;
    private Body body;
    private Maker maker;
    private CombustionEngine engine;
    private FuelTank tank;
    private Transmission transmission;
}
