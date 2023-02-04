package ua.foxminded.volodymyrtolpiekin.carrestservice.service;

import ua.foxminded.volodymyrtolpiekin.carrestservice.models.EVCar;

import java.util.List;

public interface EVCarService {

    EVCar create(EVCar ev);

    EVCar getById(Long id);

    List<EVCar> getAll();

    EVCar update(EVCar ev);

    void delete(Long id);
}
