package ua.foxminded.volodymyrtolpiekin.carrestservice.service.implementation;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;
import ua.foxminded.volodymyrtolpiekin.carrestservice.models.Body;
import ua.foxminded.volodymyrtolpiekin.carrestservice.repository.BodyRepository;
import ua.foxminded.volodymyrtolpiekin.carrestservice.service.BodyService;

import java.util.List;

@Service
@RequiredArgsConstructor
public class BodyServiceImpl implements BodyService {
    BodyRepository bodyRepository;

    @Override
    public Body create(Body body) {
        return bodyRepository.save(body);
    }

    @Override
    public Body getById(Long id) {
        return bodyRepository.findById(id).orElseThrow(() ->
                new ResponseStatusException(HttpStatus.NOT_FOUND, "Body not found"));
    }

    @Override
    public List<Body> getAll() {
        return bodyRepository.findAll();
    }

    @Override
    public Body update(Body body) {
        return bodyRepository.save(body);
    }

    @Override
    public void deleteById(Long id) {
        if (bodyRepository.existsById(id))
            bodyRepository.deleteById(id);
    }
}
