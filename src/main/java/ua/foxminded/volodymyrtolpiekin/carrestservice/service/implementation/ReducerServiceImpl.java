package ua.foxminded.volodymyrtolpiekin.carrestservice.service.implementation;

import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;
import ua.foxminded.volodymyrtolpiekin.carrestservice.models.Reducer;
import ua.foxminded.volodymyrtolpiekin.carrestservice.models.dtos.ReducerDTO;
import ua.foxminded.volodymyrtolpiekin.carrestservice.repository.ReducerRepository;
import ua.foxminded.volodymyrtolpiekin.carrestservice.service.ReducerService;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class ReducerServiceImpl implements ReducerService {

    ReducerRepository reducerRepository;
    ModelMapper mapper;

    @Override
    public Reducer create(Reducer reducer) {
        return reducerRepository.save(reducer);
    }

    @Override
    public ReducerDTO create(ReducerDTO reducerDTO) {
        Reducer reducer = mapper.map(reducerDTO, Reducer.class);
        return mapper.map(create(reducer), ReducerDTO.class);
    }

    @Override
    public Reducer findById(Long id) {
        return reducerRepository.findById(id).orElseThrow(() ->
                new ResponseStatusException(HttpStatus.NOT_FOUND, "Reducer not found"));
    }

    @Override
    public ReducerDTO getById(Long id) {
        return mapper.map(findById(id), ReducerDTO.class);
    }

    @Override
    public List<Reducer> findAll() {
        return reducerRepository.findAll();
    }

    @Override
    public List<ReducerDTO> getAll() {
        return findAll()
                .stream()
                .map(reducer -> mapper.map(reducer, ReducerDTO.class))
                .collect(Collectors.toList());
    }

    @Override
    public Reducer update(Reducer reducer) {
        return reducerRepository.save(reducer);
    }

    @Override
    public ReducerDTO update(ReducerDTO reducerDTO) {
        Reducer reducer = mapper.map(reducerDTO, Reducer.class);
        return mapper.map(update(reducer), ReducerDTO.class);
    }

    @Override
    public void deleteById(Long id) {
        if(reducerRepository.existsById(id))
            reducerRepository.deleteById(id);
    }
}
