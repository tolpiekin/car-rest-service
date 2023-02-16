package ua.foxminded.volodymyrtolpiekin.carrestservice.service.implementation;

import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;
import ua.foxminded.volodymyrtolpiekin.carrestservice.models.CombustionEngine;
import ua.foxminded.volodymyrtolpiekin.carrestservice.models.dtos.CombustionEngineDTO;
import ua.foxminded.volodymyrtolpiekin.carrestservice.repository.CombustionEngineRepository;
import ua.foxminded.volodymyrtolpiekin.carrestservice.service.CombustionEngineService;

import java.util.List;

@Service
@RequiredArgsConstructor
public class CombustionEngineServiceImpl implements CombustionEngineService {

    private final CombustionEngineRepository combustionEngineRepository;
    private final ModelMapper mapper;

    @Override
    public CombustionEngine create(CombustionEngine engine) {
        return combustionEngineRepository.save(engine);
    }

    @Override
    public CombustionEngineDTO create(CombustionEngineDTO engineDTO) {
        CombustionEngine engine = mapper.map(engineDTO, CombustionEngine.class);
        return mapper.map(create(engine), CombustionEngineDTO.class);
    }

    @Override
    public CombustionEngine findById(Long id) {
        return combustionEngineRepository.findById(id).orElseThrow(() ->
                new ResponseStatusException(HttpStatus.NOT_FOUND, "Combustion Engine not found"));
    }

    @Override
    public CombustionEngineDTO getById(Long id) {
        return mapper.map(findById(id), CombustionEngineDTO.class);
    }

    @Override
    public List<CombustionEngine> findAll() {
        return combustionEngineRepository.findAll();
    }

    @Override
    public List<CombustionEngineDTO> getAll() {
        return findAll()
                .stream()
                .map(engine -> mapper.map(engine, CombustionEngineDTO.class))
                .toList();
    }

    @Override
    public CombustionEngine update(CombustionEngine engine) {
        return combustionEngineRepository.save(engine);
    }

    @Override
    public CombustionEngineDTO update(CombustionEngineDTO engineDTO) {
        CombustionEngine engine = mapper.map(engineDTO, CombustionEngine.class);
        return mapper.map(update(engine), CombustionEngineDTO.class);
    }

    @Override
    public void deleteById(Long id) {
        if(combustionEngineRepository.existsById(id))
            combustionEngineRepository.deleteById(id);
    }
}
