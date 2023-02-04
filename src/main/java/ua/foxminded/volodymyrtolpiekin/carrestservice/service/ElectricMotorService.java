package ua.foxminded.volodymyrtolpiekin.carrestservice.service;

import ua.foxminded.volodymyrtolpiekin.carrestservice.models.ElectricMotor;
import ua.foxminded.volodymyrtolpiekin.carrestservice.models.dtos.ElectricMotorDTO;

import java.util.List;

public interface ElectricMotorService {

    ElectricMotor create(ElectricMotor motor);

    ElectricMotorDTO create(ElectricMotorDTO motorDTO);

    ElectricMotor findById(Long id);

    ElectricMotorDTO getById(Long id);

    List<ElectricMotor> findAll();

    List<ElectricMotorDTO> getAll();

    ElectricMotor update(ElectricMotor motor);

    ElectricMotorDTO update(ElectricMotorDTO motorDTO);

    void delete(Long id);
}
