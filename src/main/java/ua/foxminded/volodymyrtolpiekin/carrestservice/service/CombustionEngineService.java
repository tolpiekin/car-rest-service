package ua.foxminded.volodymyrtolpiekin.carrestservice.service;

import ua.foxminded.volodymyrtolpiekin.carrestservice.models.CombustionEngine;

import java.util.List;

public interface CombustionEngineService {

    CombustionEngine create(CombustionEngine engine);

    CombustionEngine getById(Long id);

    List<CombustionEngine> getAll();

    CombustionEngine update(CombustionEngine engine);

    void deleteById(Long id);
}
