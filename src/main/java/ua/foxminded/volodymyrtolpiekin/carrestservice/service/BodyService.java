package ua.foxminded.volodymyrtolpiekin.carrestservice.service;

import ua.foxminded.volodymyrtolpiekin.carrestservice.models.Body;

import java.util.List;

public interface BodyService {

    Body create(Body body);

    Body getById(Long id);

    List<Body> getAll();

    Body update (Body body);

    void deleteById(Long id);
}
