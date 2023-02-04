package ua.foxminded.volodymyrtolpiekin.carrestservice.service;

import ua.foxminded.volodymyrtolpiekin.carrestservice.models.Body;
import ua.foxminded.volodymyrtolpiekin.carrestservice.models.dtos.BodyDTO;

import java.util.List;

public interface BodyService {

    Body create(Body body);

    BodyDTO create(BodyDTO bodyDTO);

    Body findById(Long id);

    BodyDTO getById(Long id);

    List<Body> findAll();

    List<BodyDTO> getAll();

    Body update (Body body);

    BodyDTO update (BodyDTO bodyDTO);

    void deleteById(Long id);
}
