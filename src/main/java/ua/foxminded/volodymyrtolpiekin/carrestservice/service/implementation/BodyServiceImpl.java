package ua.foxminded.volodymyrtolpiekin.carrestservice.service.implementation;

import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.ui.ModelMap;
import org.springframework.web.server.ResponseStatusException;
import ua.foxminded.volodymyrtolpiekin.carrestservice.models.Body;
import ua.foxminded.volodymyrtolpiekin.carrestservice.models.dtos.BodyDTO;
import ua.foxminded.volodymyrtolpiekin.carrestservice.repository.BodyRepository;
import ua.foxminded.volodymyrtolpiekin.carrestservice.service.BodyService;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class BodyServiceImpl implements BodyService {
    BodyRepository bodyRepository;
    ModelMapper mapper;

    @Override
    public Body create(Body body) {
        return bodyRepository.save(body);
    }

    @Override
    public BodyDTO create(BodyDTO bodyDTO) {
        Body body = mapper.map(bodyDTO, Body.class);
        return mapper.map(create(body), BodyDTO.class);
    }

    @Override
    public Body findById(Long id) {
        return bodyRepository.findById(id).orElseThrow(() ->
                new ResponseStatusException(HttpStatus.NOT_FOUND, "Body not found"));
    }

    @Override
    public BodyDTO getById(Long id) {
        return mapper.map(findById(id), BodyDTO.class);
    }

    @Override
    public List<Body> findAll() {
        return bodyRepository.findAll();
    }

    @Override
    public List<BodyDTO> getAll() {
        return findAll()
                .stream()
                .map(body -> mapper.map(body, BodyDTO.class))
                .collect(Collectors.toList());
    }

    @Override
    public Body update(Body body) {
        return bodyRepository.save(body);
    }

    @Override
    public BodyDTO update(BodyDTO bodyDTO) {
        Body body = mapper.map(bodyDTO, Body.class);
        return mapper.map(update(body), BodyDTO.class);
    }

    @Override
    public void deleteById(Long id) {
        if (bodyRepository.existsById(id))
            bodyRepository.deleteById(id);
    }
}
