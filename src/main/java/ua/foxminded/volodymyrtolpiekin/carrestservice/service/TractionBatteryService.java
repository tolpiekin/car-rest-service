package ua.foxminded.volodymyrtolpiekin.carrestservice.service;

import ua.foxminded.volodymyrtolpiekin.carrestservice.models.TractionBattery;
import ua.foxminded.volodymyrtolpiekin.carrestservice.models.dtos.TractionBatteryDTO;

import java.util.List;

public interface TractionBatteryService {

    TractionBattery create (TractionBattery battery);

    TractionBatteryDTO create (TractionBatteryDTO batteryDTO);

    TractionBattery findById(Long id);

    TractionBatteryDTO getById(Long id);

    List<TractionBattery> findAll();

    List<TractionBatteryDTO> getAll();

    TractionBattery update(TractionBattery battery);

    TractionBatteryDTO update(TractionBatteryDTO batteryDTO);

    void deleteById(Long id);
}
