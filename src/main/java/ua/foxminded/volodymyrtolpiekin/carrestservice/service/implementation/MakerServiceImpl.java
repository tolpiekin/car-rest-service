package ua.foxminded.volodymyrtolpiekin.carrestservice.service.implementation;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;
import ua.foxminded.volodymyrtolpiekin.carrestservice.models.Maker;
import ua.foxminded.volodymyrtolpiekin.carrestservice.repository.MakerRepository;
import ua.foxminded.volodymyrtolpiekin.carrestservice.service.MakerService;

import java.util.List;

@Service
@RequiredArgsConstructor
public class MakerServiceImpl implements MakerService {

    MakerRepository makerRepository;

    @Override
    public Maker create(Maker maker) {
        return makerRepository.save(maker);
    }

    @Override
    public Maker getById(Long id) {
        return makerRepository.findById(id).orElseThrow(() ->
                new ResponseStatusException(HttpStatus.NOT_FOUND, "Maker not found"));
    }

    @Override
    public List<Maker> getAll() {
        return makerRepository.findAll();
    }

    @Override
    public Maker update(Maker maker) {
        return makerRepository.save(maker);
    }

    @Override
    public void deleteById(Long id) {
        if(makerRepository.existsById(id))
            makerRepository.deleteById(id);
    }
}
