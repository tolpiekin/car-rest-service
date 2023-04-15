package ua.foxminded.volodymyrtolpiekin.carrestservice.service.implementation;

import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;
import ua.foxminded.volodymyrtolpiekin.carrestservice.models.OnBoardCharger;
import ua.foxminded.volodymyrtolpiekin.carrestservice.models.dtos.OnBoardChargerDTO;
import ua.foxminded.volodymyrtolpiekin.carrestservice.repository.OnBoardChargerRepository;
import ua.foxminded.volodymyrtolpiekin.carrestservice.service.OnBoardChargerService;

import java.util.List;

@Service
@RequiredArgsConstructor
public class OnBoardChargerServiceImpl implements OnBoardChargerService {

    private final OnBoardChargerRepository onBoardChargerRepository;
    private final ModelMapper mapper;

    @Override
    public OnBoardCharger create(OnBoardCharger charger) {
        return onBoardChargerRepository.save(charger);
    }

    @Override
    public OnBoardChargerDTO create(OnBoardChargerDTO chargerDTO) {
        OnBoardCharger charger = mapper.map(chargerDTO, OnBoardCharger.class);
        return mapper.map(create(charger), OnBoardChargerDTO.class);
    }

    @Override
    public OnBoardCharger findById(Long id) {
        return onBoardChargerRepository.findById(id).orElseThrow(() ->
                new ResponseStatusException(HttpStatus.NOT_FOUND, "On Board Charger not found"));
    }

    @Override
    public OnBoardChargerDTO getById(Long id) {
        return mapper.map(findById(id), OnBoardChargerDTO.class);
    }

    @Override
    public List<OnBoardCharger> findAll() {
        return onBoardChargerRepository.findAll();
    }

    @Override
    public List<OnBoardChargerDTO> getAll() {
        return findAll()
                .stream()
                .map(charger -> mapper.map(charger, OnBoardChargerDTO.class))
                .toList();
    }

    @Override
    public OnBoardCharger update(OnBoardCharger charger) {
        return onBoardChargerRepository.save(charger);
    }

    @Override
    public OnBoardChargerDTO update(OnBoardChargerDTO chargerDTO) {
        OnBoardCharger charger = mapper.map(chargerDTO, OnBoardCharger.class);
        return mapper.map(update(charger), OnBoardChargerDTO.class);
    }

    @Override
    public void deleteById(Long id) {
        if(onBoardChargerRepository.existsById(id))
            onBoardChargerRepository.deleteById(id);
    }
}
