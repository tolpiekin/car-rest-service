package ua.foxminded.volodymyrtolpiekin.carrestservice.service;

import ua.foxminded.volodymyrtolpiekin.carrestservice.models.OnBoardCharger;

import java.util.List;

public interface OnBoardChargerService {

    OnBoardCharger create(OnBoardCharger charger);

    OnBoardCharger getById(Long id);

    List<OnBoardCharger> getAll();

    OnBoardCharger update(OnBoardCharger charger);

    void deleteById (Long id);
}
