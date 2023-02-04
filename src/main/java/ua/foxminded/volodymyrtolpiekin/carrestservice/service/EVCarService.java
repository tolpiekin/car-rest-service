package ua.foxminded.volodymyrtolpiekin.carrestservice.service;

import ua.foxminded.volodymyrtolpiekin.carrestservice.models.EVCar;
import ua.foxminded.volodymyrtolpiekin.carrestservice.models.dtos.EVCarDTO;

import java.util.List;

public interface EVCarService {

    EVCar create(EVCar ev);

    EVCarDTO create(EVCarDTO evDTO);

    EVCar findById(Long id);

    EVCarDTO getById(Long id);

    List<EVCar> findAll();

    List<EVCarDTO> getAll();

    EVCar update(EVCar ev);

    EVCarDTO update(EVCarDTO evDTO);

    void delete(Long id);
}
