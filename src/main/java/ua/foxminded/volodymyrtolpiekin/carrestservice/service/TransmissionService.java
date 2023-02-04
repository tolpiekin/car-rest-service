package ua.foxminded.volodymyrtolpiekin.carrestservice.service;

import ua.foxminded.volodymyrtolpiekin.carrestservice.models.Transmission;

import java.util.List;

public interface TransmissionService {

    Transmission create (Transmission transmission);

    Transmission getById(Long id);

    List<Transmission> getAll();

    Transmission update(Transmission transmission);

    void deleteById(Long id);
}
