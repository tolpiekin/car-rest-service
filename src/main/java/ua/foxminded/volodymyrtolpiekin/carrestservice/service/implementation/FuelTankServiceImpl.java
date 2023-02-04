package ua.foxminded.volodymyrtolpiekin.carrestservice.service.implementation;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;
import ua.foxminded.volodymyrtolpiekin.carrestservice.models.FuelTank;
import ua.foxminded.volodymyrtolpiekin.carrestservice.repository.FuelTankRepository;
import ua.foxminded.volodymyrtolpiekin.carrestservice.service.FuelTankService;

import java.util.List;

@Service
@RequiredArgsConstructor
public class FuelTankServiceImpl implements FuelTankService {

    FuelTankRepository fuelTankRepository;
    @Override
    public FuelTank create(FuelTank tank) {
        return fuelTankRepository.save(tank);
    }

    @Override
    public FuelTank getById(Long id) {
        return fuelTankRepository.findById(id).orElseThrow(() ->
                new ResponseStatusException(HttpStatus.NOT_FOUND, "Fuel Tank not found"));
    }

    @Override
    public List<FuelTank> getAll() {
        return fuelTankRepository.findAll();
    }

    @Override
    public FuelTank update(FuelTank tank) {
        return fuelTankRepository.save(tank);
    }

    @Override
    public void deleteById(Long id) {
        if(fuelTankRepository.existsById(id))
            fuelTankRepository.deleteById(id);
    }
}
