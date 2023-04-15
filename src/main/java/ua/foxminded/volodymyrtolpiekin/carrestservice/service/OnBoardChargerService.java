package ua.foxminded.volodymyrtolpiekin.carrestservice.service;

import ua.foxminded.volodymyrtolpiekin.carrestservice.models.OnBoardCharger;
import ua.foxminded.volodymyrtolpiekin.carrestservice.models.dtos.OnBoardChargerDTO;

import java.util.List;

public interface OnBoardChargerService {

    OnBoardCharger create(OnBoardCharger charger);

    OnBoardChargerDTO create(OnBoardChargerDTO chargerDTO);

    OnBoardCharger findById(Long id);

    OnBoardChargerDTO getById(Long id);

    List<OnBoardCharger> findAll();

    List<OnBoardChargerDTO> getAll();

    OnBoardCharger update(OnBoardCharger charger);

    OnBoardChargerDTO update(OnBoardChargerDTO chargerDTO);

    void deleteById (Long id);
}
