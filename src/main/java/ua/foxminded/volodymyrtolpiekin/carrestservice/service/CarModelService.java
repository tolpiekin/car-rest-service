package ua.foxminded.volodymyrtolpiekin.carrestservice.service;

import ua.foxminded.volodymyrtolpiekin.carrestservice.models.CarModel;
import ua.foxminded.volodymyrtolpiekin.carrestservice.models.dtos.CarModelDTO;

import java.util.List;
import java.util.Set;

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

    boolean ifExistsByName(String model);

    CarModel findByName(String model);

    Set<Integer> getAllYears();

    List<CarModelDTO> getByYear(int year);
}
