package ua.foxminded.volodymyrtolpiekin.carrestservice.service.implementation;

import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.ui.ModelMap;
import org.springframework.web.server.ResponseStatusException;
import ua.foxminded.volodymyrtolpiekin.carrestservice.models.Car;
import ua.foxminded.volodymyrtolpiekin.carrestservice.models.dtos.CarDTO;
import ua.foxminded.volodymyrtolpiekin.carrestservice.repository.CarRepository;
import ua.foxminded.volodymyrtolpiekin.carrestservice.service.CarService;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class CarServiceImpl implements CarService {

    CarRepository carRepository;
    ModelMapper mapper;

    @Override
    public Car create(Car car) {
        return carRepository.save(car);
    }

    @Override
    public CarDTO create(CarDTO carDTO) {
        Car car = mapper.map(carDTO, Car.class);
        return mapper.map(create(car), CarDTO.class);
    }

    @Override
    public Car findById(Long id) {
        return carRepository.findById(id).orElseThrow(() ->
                new ResponseStatusException(HttpStatus.NOT_FOUND, "Car not found"));
    }

    @Override
    public CarDTO getById(Long id) {
        return mapper.map(findById(id), CarDTO.class);
    }

    @Override
    public List<Car> findAll() {
        return carRepository.findAll();
    }

    @Override
    public List<CarDTO> getAll() {
        return findAll()
                .stream()
                .map(car -> mapper.map(car, CarDTO.class))
                .collect(Collectors.toList());
    }

    @Override
    public Car update(Car car) {
        return carRepository.save(car);
    }

    @Override
    public CarDTO update(CarDTO carDTO) {
        Car car = mapper.map(carDTO, Car.class);
        return mapper.map(update(car), CarDTO.class);
    }

    @Override
    public void deleteById(Long id) {
        if(carRepository.existsById(id))
            carRepository.deleteById(id);
    }
}
