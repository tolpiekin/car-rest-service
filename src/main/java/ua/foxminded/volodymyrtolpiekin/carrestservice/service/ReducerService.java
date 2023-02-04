package ua.foxminded.volodymyrtolpiekin.carrestservice.service;

import ua.foxminded.volodymyrtolpiekin.carrestservice.models.Reducer;
import ua.foxminded.volodymyrtolpiekin.carrestservice.models.dtos.ReducerDTO;

import java.util.List;

public interface ReducerService {

    Reducer create (Reducer reducer);

    ReducerDTO create (ReducerDTO reducerDTO);

    Reducer findById(Long id);

    ReducerDTO getById(Long id);

    List<Reducer> findAll();

    List<ReducerDTO> getAll();

    Reducer update(Reducer reducer);

    ReducerDTO update(ReducerDTO reducerDTO);

    void deleteById(Long id);
}
