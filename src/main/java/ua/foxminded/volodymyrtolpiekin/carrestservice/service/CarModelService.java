package ua.foxminded.volodymyrtolpiekin.carrestservice.service;

import ua.foxminded.volodymyrtolpiekin.carrestservice.models.CarModel;
import ua.foxminded.volodymyrtolpiekin.carrestservice.models.dtos.CarModelDTO;

import java.util.List;

public interface CarModelService {

    CarModel create(CarModel carModel);

    CarModelDTO create(CarModelDTO carModelDTO);

    CarModel findById(Long id);

    CarModelDTO getById(Long id);

    List<CarModel> findAll();

    List<CarModelDTO> getAll();

    CarModel update(CarModel carModel);

    CarModelDTO update(CarModelDTO carModelDTO);

    void deleteById(Long id);
}
