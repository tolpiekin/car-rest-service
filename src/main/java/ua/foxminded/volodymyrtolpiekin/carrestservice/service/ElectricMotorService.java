package ua.foxminded.volodymyrtolpiekin.carrestservice.service;

import ua.foxminded.volodymyrtolpiekin.carrestservice.models.ElectricMotor;

import java.util.List;

public interface ElectricMotorService {

    ElectricMotor create(ElectricMotor motor);

    ElectricMotor getById(Long id);

    List<ElectricMotor> getAll();

    ElectricMotor update(ElectricMotor motor);

    void delete(Long id);
}
