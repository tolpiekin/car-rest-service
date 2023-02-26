package ua.foxminded.volodymyrtolpiekin.carrestservice.service;

import ua.foxminded.volodymyrtolpiekin.carrestservice.models.CarModel;
import ua.foxminded.volodymyrtolpiekin.carrestservice.models.Maker;
import ua.foxminded.volodymyrtolpiekin.carrestservice.models.dtos.CarModelDTO;
import ua.foxminded.volodymyrtolpiekin.carrestservice.models.dtos.MakerDTO;

import java.util.List;

public interface MakerService {

    Maker create(Maker maker);

    MakerDTO create(MakerDTO makerDTO);

    Maker findById(Long id);

    MakerDTO getById(Long id);

    List<Maker> findAll();

    List<MakerDTO> getAll();

    Maker update(Maker maker);

    MakerDTO update(MakerDTO makerDTO);

    void deleteById(Long id);

    boolean ifExistsByName(String manufacturerName);

    Maker findByName(String make);
}
