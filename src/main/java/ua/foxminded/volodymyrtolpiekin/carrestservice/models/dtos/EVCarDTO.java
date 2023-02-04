package ua.foxminded.volodymyrtolpiekin.carrestservice.models.dtos;

import ua.foxminded.volodymyrtolpiekin.carrestservice.models.*;

public class EVCarDTO {
    private Long id;
    private CarModel model;
    private int year;
    private Body body;
    private Maker maker;
    private ElectricMotor engine;
    private TractionBattery battery;
    private Reducer reducer;
    private OnBoardCharger charger;
}
