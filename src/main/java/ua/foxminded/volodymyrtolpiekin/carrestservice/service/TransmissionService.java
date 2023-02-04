package ua.foxminded.volodymyrtolpiekin.carrestservice.service;

import ua.foxminded.volodymyrtolpiekin.carrestservice.models.Transmission;
import ua.foxminded.volodymyrtolpiekin.carrestservice.models.dtos.TransmissionDTO;

import java.util.List;

public interface TransmissionService {

    Transmission create (Transmission transmission);

    TransmissionDTO create (TransmissionDTO transmissionDTO);

    Transmission findById(Long id);

    TransmissionDTO getById(Long id);

    List<Transmission> findAll();

    List<TransmissionDTO> getAll();

    Transmission update(Transmission transmission);

    TransmissionDTO update(TransmissionDTO transmissionDTO);

    void deleteById(Long id);
}
