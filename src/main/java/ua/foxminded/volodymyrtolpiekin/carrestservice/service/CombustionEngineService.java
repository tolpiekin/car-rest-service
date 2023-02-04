package ua.foxminded.volodymyrtolpiekin.carrestservice.service;

import ua.foxminded.volodymyrtolpiekin.carrestservice.models.CombustionEngine;
import ua.foxminded.volodymyrtolpiekin.carrestservice.models.dtos.CombustionEngineDTO;

import java.util.List;

public interface CombustionEngineService {

    CombustionEngine create(CombustionEngine engine);

    CombustionEngineDTO create(CombustionEngineDTO engineDTO);

    CombustionEngine findById(Long id);

    CombustionEngineDTO getById(Long id);

    List<CombustionEngine> findAll();

    List<CombustionEngineDTO> getAll();

    CombustionEngine update(CombustionEngine engine);

    CombustionEngineDTO update(CombustionEngineDTO engineDTO);

    void deleteById(Long id);
}
