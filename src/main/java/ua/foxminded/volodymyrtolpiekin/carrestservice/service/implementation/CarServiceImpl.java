package ua.foxminded.volodymyrtolpiekin.carrestservice.service.implementation;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;
import ua.foxminded.volodymyrtolpiekin.carrestservice.models.Car;
import ua.foxminded.volodymyrtolpiekin.carrestservice.repository.CarRepository;
import ua.foxminded.volodymyrtolpiekin.carrestservice.service.CarService;

import java.util.List;

@Service
@RequiredArgsConstructor
public class CarServiceImpl implements CarService {

    CarRepository carRepository;

    @Override
    public Car create(Car car) {
        return carRepository.save(car);
    }

    @Override
    public Car getById(Long id) {
        return carRepository.findById(id).orElseThrow(() ->
                new ResponseStatusException(HttpStatus.NOT_FOUND, "Car not found"));
    }

    @Override
    public List<Car> getAll() {
        return carRepository.findAll();
    }

    @Override
    public Car update(Car car) {
        return carRepository.save(car);
    }

    @Override
    public void deleteById(Long id) {
        if(carRepository.existsById(id))
            carRepository.deleteById(id);
    }
}
