package ua.foxminded.volodymyrtolpiekin.carrestservice.service.implementation;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;
import ua.foxminded.volodymyrtolpiekin.carrestservice.models.Reducer;
import ua.foxminded.volodymyrtolpiekin.carrestservice.repository.ReducerRepository;
import ua.foxminded.volodymyrtolpiekin.carrestservice.service.ReducerService;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ReducerServiceImpl implements ReducerService {

    ReducerRepository reducerRepository;

    @Override
    public Reducer create(Reducer reducer) {
        return reducerRepository.save(reducer);
    }

    @Override
    public Reducer getById(Long id) {
        return reducerRepository.findById(id).orElseThrow(() ->
                new ResponseStatusException(HttpStatus.NOT_FOUND, "Reducer not found"));
    }

    @Override
    public List<Reducer> getAll() {
        return reducerRepository.findAll();
    }

    @Override
    public Reducer update(Reducer reducer) {
        return reducerRepository.save(reducer);
    }

    @Override
    public void deleteById(Long id) {
        if(reducerRepository.existsById(id))
            reducerRepository.deleteById(id);
    }
}
