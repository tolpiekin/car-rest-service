package ua.foxminded.volodymyrtolpiekin.carrestservice.service.implementation;

import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;
import ua.foxminded.volodymyrtolpiekin.carrestservice.models.FuelTank;
import ua.foxminded.volodymyrtolpiekin.carrestservice.models.dtos.FuelTankDTO;
import ua.foxminded.volodymyrtolpiekin.carrestservice.repository.FuelTankRepository;
import ua.foxminded.volodymyrtolpiekin.carrestservice.service.FuelTankService;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class FuelTankServiceImpl implements FuelTankService {

    FuelTankRepository fuelTankRepository;
    ModelMapper mapper;
    @Override
    public FuelTank create(FuelTank tank) {
        return fuelTankRepository.save(tank);
    }

    @Override
    public FuelTankDTO create(FuelTankDTO tankDTO) {
        FuelTank tank = mapper.map(tankDTO, FuelTank.class);
        return mapper.map(create(tank), FuelTankDTO.class);
    }

    @Override
    public FuelTank findById(Long id) {
        return fuelTankRepository.findById(id).orElseThrow(() ->
                new ResponseStatusException(HttpStatus.NOT_FOUND, "Fuel Tank not found"));
    }

    @Override
    public FuelTankDTO getById(Long id) {
        return mapper.map(findById(id), FuelTankDTO.class);
    }

    @Override
    public List<FuelTank> findAll() {
        return fuelTankRepository.findAll();
    }

    @Override
    public List<FuelTankDTO> getAll() {
        return findAll()
                .stream()
                .map(tank -> mapper.map(tank, FuelTankDTO.class))
                .collect(Collectors.toList());
    }

    @Override
    public FuelTank update(FuelTank tank) {
        return fuelTankRepository.save(tank);
    }

    @Override
    public FuelTankDTO update(FuelTankDTO tankDTO) {
        FuelTank tank = mapper.map(tankDTO, FuelTank.class);
        return mapper.map(update(tank), FuelTankDTO.class);
    }

    @Override
    public void deleteById(Long id) {
        if(fuelTankRepository.existsById(id))
            fuelTankRepository.deleteById(id);
    }
}
