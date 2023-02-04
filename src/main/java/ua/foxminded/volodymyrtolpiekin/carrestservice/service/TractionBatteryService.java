package ua.foxminded.volodymyrtolpiekin.carrestservice.service;

import ua.foxminded.volodymyrtolpiekin.carrestservice.models.TractionBattery;

import java.util.List;

public interface TractionBatteryService {

    TractionBattery create (TractionBattery battery);

    TractionBattery getById(Long id);

    List<TractionBattery> getAll();

    TractionBattery update(TractionBattery battery);

    void deleteById(Long id);
}
