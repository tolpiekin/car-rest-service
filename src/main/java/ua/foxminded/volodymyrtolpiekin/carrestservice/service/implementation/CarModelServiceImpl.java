package ua.foxminded.volodymyrtolpiekin.carrestservice.service.implementation;

import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;
import ua.foxminded.volodymyrtolpiekin.carrestservice.models.CarModel;
import ua.foxminded.volodymyrtolpiekin.carrestservice.models.Maker;
import ua.foxminded.volodymyrtolpiekin.carrestservice.models.dtos.CarModelDTO;
import ua.foxminded.volodymyrtolpiekin.carrestservice.repository.CarModelRepository;
import ua.foxminded.volodymyrtolpiekin.carrestservice.service.CarModelService;
import ua.foxminded.volodymyrtolpiekin.carrestservice.service.MakerService;

import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class CarModelServiceImpl implements CarModelService {

    private final CarModelRepository carModelRepository;
    private final MakerService makerService;
    private final ModelMapper mapper;

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
                .toList();
    }

    @Override
    public CarModel update(CarModel carModel) {
        return carModelRepository.save(carModel);
    }

    @Override
    public CarModelDTO update(CarModelDTO carModelDTO) {
        CarModel carModel = mapper.map(carModelDTO, CarModel.class);
        return mapper.map(update(carModel), CarModelDTO.class);
    }

    @Override
    public void deleteById(Long id) {
        if (carModelRepository.existsById(id))
            carModelRepository.deleteById(id);
    }

    @Override
    public boolean ifExistsByName(String modelName) {
        return carModelRepository.existsByName(modelName);
    }

    @Override
    public Set<Integer> getAllYears() {
        return carModelRepository.findAll().stream().map(CarModel::getYear).collect(Collectors.toSet());
    }

    @Override
    public List<CarModelDTO> getByName(String modelName) {
        return carModelRepository.findByName(modelName);
    }

    @Override
    public List<CarModelDTO> getMakerModels(String makerName) {
        return getAll().stream().filter(m -> m.getMaker().getName().equals(makerName)).toList();
    }

    @Override
    public CarModelDTO create(String makerName, String modelName, int year) {
        Maker maker = makerService.findByName(makerName);
        CarModel carModel = new CarModel();
        carModel.setMaker(maker);
        carModel.setName(modelName);
        carModel.setYear(year);
        return mapper.map(carModelRepository.save(carModel), CarModelDTO.class);
    }

    @Override
    public void deleteByNameAndYear(String makerName, String modelName, int year) {
        List<Long> idsToDelete = getByNameAndYear(makerName, modelName, year).stream().map(CarModelDTO::getId).toList();
        idsToDelete.forEach(this::deleteById);
    }

    @Override
    public List<CarModelDTO> getByNameAndYear(String makerName, String modelName, int year) {
        return getMakerModels(makerName).stream().filter(model -> model.getName().equals(modelName) &&
                model.getYear() == year).toList();
    }

    @Override
    public CarModelDTO updateByNameAndYear(String makerName, String modelName, int year) {
        Maker maker = makerService.findByName(makerName);
        CarModel carModel = new CarModel();
        carModel.setMaker(maker);
        carModel.setName(modelName);
        carModel.setYear(year);
        return mapper.map(carModelRepository.save(carModel), CarModelDTO.class);
    }
}
