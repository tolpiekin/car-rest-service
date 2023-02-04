package ua.foxminded.volodymyrtolpiekin.carrestservice.service.implementation;

import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;
import ua.foxminded.volodymyrtolpiekin.carrestservice.models.EVCar;
import ua.foxminded.volodymyrtolpiekin.carrestservice.models.dtos.EVCarDTO;
import ua.foxminded.volodymyrtolpiekin.carrestservice.repository.EVCarRepository;
import ua.foxminded.volodymyrtolpiekin.carrestservice.service.EVCarService;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class EVCarServiceImpl implements EVCarService {

    EVCarRepository evCarRepository;
    ModelMapper mapper;

    @Override
    public EVCar create(EVCar ev) {
        return evCarRepository.save(ev);
    }

    @Override
    public EVCarDTO create(EVCarDTO evDTO) {
        EVCar ev = mapper.map(evDTO, EVCar.class);
        return mapper.map(create(ev), EVCarDTO.class);
    }

    @Override
    public EVCar findById(Long id) {
        return evCarRepository.findById(id).orElseThrow(() ->
                new ResponseStatusException(HttpStatus.NOT_FOUND, "EV Car not found"));
    }

    @Override
    public EVCarDTO getById(Long id) {
        return mapper.map(findById(id), EVCarDTO.class);
    }

    @Override
    public List<EVCar> findAll() {
        return evCarRepository.findAll();
    }

    @Override
    public List<EVCarDTO> getAll() {
        return findAll()
                .stream()
                .map(ev -> mapper.map(ev, EVCarDTO.class))
                .collect(Collectors.toList());
    }

    @Override
    public EVCar update(EVCar ev) {
        return evCarRepository.save(ev);
    }

    @Override
    public EVCarDTO update(EVCarDTO evDTO) {
        EVCar ev = mapper.map(evDTO, EVCar.class);
        return mapper.map(update(ev), EVCarDTO.class);
    }

    @Override
    public void delete(Long id) {
        if(evCarRepository.existsById(id))
            evCarRepository.deleteById(id);
    }
}
