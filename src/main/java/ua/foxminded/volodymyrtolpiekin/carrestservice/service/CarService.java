package ua.foxminded.volodymyrtolpiekin.carrestservice.service;

import ua.foxminded.volodymyrtolpiekin.carrestservice.models.Car;
import ua.foxminded.volodymyrtolpiekin.carrestservice.models.dtos.CarDTO;

import java.util.List;

public interface CarService {

    Car create(Car car);

    CarDTO create(CarDTO carDTO);

    Car findById(Long id);

    CarDTO getById(Long id);

    List<Car> findAll();

    List<CarDTO> getAll();

    Car update(Car car);

    CarDTO update(CarDTO carDTO);

    void deleteById(Long id);

    List<CarDTO> getByManufacturerAndYear(String manufacturerName, String modelName, int year);
}
