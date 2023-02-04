package ua.foxminded.volodymyrtolpiekin.carrestservice.service;

import ua.foxminded.volodymyrtolpiekin.carrestservice.models.Reducer;

import java.util.List;

public interface ReducerService {

    Reducer create (Reducer reducer);

    Reducer getById(Long id);

    List<Reducer> getAll();

    Reducer update(Reducer reducer);

    void deleteById(Long id);
}
