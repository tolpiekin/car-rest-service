package ua.foxminded.volodymyrtolpiekin.carrestservice.service.implementation;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;
import ua.foxminded.volodymyrtolpiekin.carrestservice.models.CarModel;
import ua.foxminded.volodymyrtolpiekin.carrestservice.repository.CarModelRepository;
import ua.foxminded.volodymyrtolpiekin.carrestservice.service.CarModelService;

import java.util.List;

@Service
@RequiredArgsConstructor
public class CarModelServiceImpl implements CarModelService {

    CarModelRepository carModelRepository;

    @Override
    public CarModel create(CarModel carModel) {
        return carModelRepository.save(carModel);
    }

    @Override
    public CarModel getById(Long id) {
        return carModelRepository.findById(id).orElseThrow(() ->
                new ResponseStatusException(HttpStatus.NOT_FOUND, "Car Model not found"));
    }

    @Override
    public List<CarModel> getAll() {
        return carModelRepository.findAll();
    }

    @Override
    public CarModel update(CarModel carModel) {
        return carModelRepository.save(carModel);
    }

    @Override
    public void deleteById(Long id) {
        if (carModelRepository.existsById(id))
            carModelRepository.deleteById(id);
    }
}
