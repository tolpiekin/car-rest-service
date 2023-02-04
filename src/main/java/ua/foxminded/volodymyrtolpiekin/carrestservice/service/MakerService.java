package ua.foxminded.volodymyrtolpiekin.carrestservice.service;

import ua.foxminded.volodymyrtolpiekin.carrestservice.models.Maker;

import java.util.List;

public interface MakerService {

    Maker create(Maker maker);

    Maker getById(Long id);

    List<Maker> getAll();

    Maker update(Maker maker);

    void deleteById(Long id);
}
