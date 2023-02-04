package ua.foxminded.volodymyrtolpiekin.carrestservice.service.implementation;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;
import ua.foxminded.volodymyrtolpiekin.carrestservice.models.EVCar;
import ua.foxminded.volodymyrtolpiekin.carrestservice.repository.EVCarRepository;
import ua.foxminded.volodymyrtolpiekin.carrestservice.service.EVCarService;

import java.util.List;

@Service
@RequiredArgsConstructor
public class EVCarServiceImpl implements EVCarService {

    EVCarRepository evCarRepository;


    @Override
    public EVCar create(EVCar ev) {
        return evCarRepository.save(ev);
    }

    @Override
    public EVCar getById(Long id) {
        return evCarRepository.findById(id).orElseThrow(() ->
                new ResponseStatusException(HttpStatus.NOT_FOUND, "EV Car not found"));
    }

    @Override
    public List<EVCar> getAll() {
        return evCarRepository.findAll();
    }

    @Override
    public EVCar update(EVCar ev) {
        return evCarRepository.save(ev);
    }

    @Override
    public void delete(Long id) {
        if(evCarRepository.existsById(id))
            evCarRepository.deleteById(id);
    }
}
