package ua.foxminded.volodymyrtolpiekin.carrestservice.service.implementation;

import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;
import ua.foxminded.volodymyrtolpiekin.carrestservice.models.Maker;
import ua.foxminded.volodymyrtolpiekin.carrestservice.models.dtos.MakerDTO;
import ua.foxminded.volodymyrtolpiekin.carrestservice.repository.MakerRepository;
import ua.foxminded.volodymyrtolpiekin.carrestservice.service.MakerService;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class MakerServiceImpl implements MakerService {

    MakerRepository makerRepository;
    ModelMapper mapper;

    @Override
    public Maker create(Maker maker) {
        return makerRepository.save(maker);
    }

    @Override
    public MakerDTO create(MakerDTO makerDTO) {
        Maker maker = mapper.map(makerDTO, Maker.class);
        return mapper.map(create(maker), MakerDTO.class);
    }

    @Override
    public Maker findById(Long id) {
        return makerRepository.findById(id).orElseThrow(() ->
                new ResponseStatusException(HttpStatus.NOT_FOUND, "Maker not found"));
    }

    @Override
    public MakerDTO getById(Long id) {
        return mapper.map(findById(id), MakerDTO.class);
    }

    @Override
    public List<Maker> findAll() {
        return makerRepository.findAll();
    }

    @Override
    public List<MakerDTO> getAll() {
        return findAll()
                .stream()
                .map(maker -> mapper.map(maker, MakerDTO.class))
                .collect(Collectors.toList());
    }

    @Override
    public Maker update(Maker maker) {
        return makerRepository.save(maker);
    }

    @Override
    public MakerDTO update(MakerDTO makerDTO) {
        Maker maker = mapper.map(makerDTO, Maker.class);
        return mapper.map(update(maker), MakerDTO.class);
    }

    @Override
    public void deleteById(Long id) {
        if(makerRepository.existsById(id))
            makerRepository.deleteById(id);
    }
}
