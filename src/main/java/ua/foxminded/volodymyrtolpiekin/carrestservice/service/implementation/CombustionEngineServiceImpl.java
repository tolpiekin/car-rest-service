package ua.foxminded.volodymyrtolpiekin.carrestservice.service.implementation;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;
import ua.foxminded.volodymyrtolpiekin.carrestservice.models.CombustionEngine;
import ua.foxminded.volodymyrtolpiekin.carrestservice.repository.CombustionEngineRepository;
import ua.foxminded.volodymyrtolpiekin.carrestservice.service.CombustionEngineService;

import java.util.List;

@Service
@RequiredArgsConstructor
public class CombustionEngineServiceImpl implements CombustionEngineService {

    CombustionEngineRepository combustionEngineRepository;

    @Override
    public CombustionEngine create(CombustionEngine engine) {
        return combustionEngineRepository.save(engine);
    }

    @Override
    public CombustionEngine getById(Long id) {
        return combustionEngineRepository.findById(id).orElseThrow(() ->
                new ResponseStatusException(HttpStatus.NOT_FOUND, "Combustion Engine not found"));
    }

    @Override
    public List<CombustionEngine> getAll() {
        return combustionEngineRepository.findAll();
    }

    @Override
    public CombustionEngine update(CombustionEngine engine) {
        return combustionEngineRepository.save(engine);
    }

    @Override
    public void deleteById(Long id) {
        if(combustionEngineRepository.existsById(id))
            combustionEngineRepository.deleteById(id);
    }
}
