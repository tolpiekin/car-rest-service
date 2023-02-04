package ua.foxminded.volodymyrtolpiekin.carrestservice.service;

import ua.foxminded.volodymyrtolpiekin.carrestservice.models.FuelTank;

import java.util.List;

public interface FuelTankService {

    FuelTank create(FuelTank tank);

    FuelTank getById(Long id);

    List<FuelTank> getAll();

    FuelTank update(FuelTank tank);

    void deleteById(Long id);
}
