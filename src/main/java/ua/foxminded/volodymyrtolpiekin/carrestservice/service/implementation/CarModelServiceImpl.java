package ua.foxminded.volodymyrtolpiekin.carrestservice.service.implementation;

import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;
import ua.foxminded.volodymyrtolpiekin.carrestservice.models.CarModel;
import ua.foxminded.volodymyrtolpiekin.carrestservice.models.dtos.CarModelDTO;
import ua.foxminded.volodymyrtolpiekin.carrestservice.repository.CarModelRepository;
import ua.foxminded.volodymyrtolpiekin.carrestservice.service.CarModelService;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class CarModelServiceImpl implements CarModelService {

    CarModelRepository carModelRepository;
    ModelMapper mapper;

    @Override
    public CarModel create(CarModel carModel) {
        return carModelRepository.save(carModel);
    }

    @Override
    public CarModelDTO create(CarModelDTO carModelDTO) {
        CarModel carModel = mapper.map(carModelDTO, CarModel.class);
        return mapper.map(create(carModel), CarModelDTO.class);
    }

    @Override
    public CarModel findById(Long id) {
        return carModelRepository.findById(id).orElseThrow(() ->
                new ResponseStatusException(HttpStatus.NOT_FOUND, "Car Model not found"));
    }

    @Override
    public CarModelDTO getById(Long id) {
        return mapper.map(findById(id), CarModelDTO.class);
    }

    @Override
    public List<CarModel> findAll() {
        return carModelRepository.findAll();
    }

    @Override
    public List<CarModelDTO> getAll() {
        return findAll()
                .stream()
                .map(carModel -> mapper.map(carModel, CarModelDTO.class))
                .collect(Collectors.toList());
    }

    @Override
    public CarModel update(CarModel carModel) {
        return carModelRepository.save(carModel);
    }

    @Override
    public CarModelDTO update(CarModelDTO carModelDTO) {
        CarModel carModel = mapper.map(carModelDTO, CarModel.class);
        return mapper.map(update(carModelDTO), CarModelDTO.class);
    }

    @Override
    public void deleteById(Long id) {
        if (carModelRepository.existsById(id))
            carModelRepository.deleteById(id);
    }
}
