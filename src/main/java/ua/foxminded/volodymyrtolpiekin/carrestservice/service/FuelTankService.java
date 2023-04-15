package ua.foxminded.volodymyrtolpiekin.carrestservice.service;

import ua.foxminded.volodymyrtolpiekin.carrestservice.models.FuelTank;
import ua.foxminded.volodymyrtolpiekin.carrestservice.models.dtos.FuelTankDTO;

import java.util.List;

public interface FuelTankService {

    FuelTank create(FuelTank tank);

    FuelTankDTO create(FuelTankDTO tankDTO);

    FuelTank findById(Long id);

    FuelTankDTO getById(Long id);

    List<FuelTank> findAll();

    List<FuelTankDTO> getAll();

    FuelTank update(FuelTank tank);

    FuelTankDTO update(FuelTankDTO tankDTO);

    void deleteById(Long id);
}
