package ua.foxminded.volodymyrtolpiekin.carrestservice.service;

import ua.foxminded.volodymyrtolpiekin.carrestservice.models.Car;

import java.util.List;

public interface CarService {

    Car create(Car car);

    Car getById(Long id);

    List<Car> getAll();

    Car update(Car car);

    void deleteById(Long id);
}
