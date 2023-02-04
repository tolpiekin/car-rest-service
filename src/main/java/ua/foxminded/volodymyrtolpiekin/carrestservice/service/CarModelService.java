package ua.foxminded.volodymyrtolpiekin.carrestservice.service;

import ua.foxminded.volodymyrtolpiekin.carrestservice.models.CarModel;

import java.util.List;

public interface CarModelService {

    CarModel create(CarModel carModel);

    CarModel getById(Long id);

    List<CarModel> getAll();

    CarModel update(CarModel carModel);

    void deleteById(Long id);
}
