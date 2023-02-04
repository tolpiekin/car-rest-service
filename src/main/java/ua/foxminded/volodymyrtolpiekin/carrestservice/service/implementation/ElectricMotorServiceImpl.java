package ua.foxminded.volodymyrtolpiekin.carrestservice.service.implementation;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;
import ua.foxminded.volodymyrtolpiekin.carrestservice.models.ElectricMotor;
import ua.foxminded.volodymyrtolpiekin.carrestservice.repository.ElectricMotorRepository;
import ua.foxminded.volodymyrtolpiekin.carrestservice.service.ElectricMotorService;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ElectricMotorServiceImpl implements ElectricMotorService {

    ElectricMotorRepository electricMotorRepository;
    @Override
    public ElectricMotor create(ElectricMotor motor) {
        return electricMotorRepository.save(motor);
    }

    @Override
    public ElectricMotor getById(Long id) {
        return electricMotorRepository.findById(id).orElseThrow(() ->
                new ResponseStatusException(HttpStatus.NOT_FOUND, "Electric Motor not found"));
    }

    @Override
    public List<ElectricMotor> getAll() {
        return electricMotorRepository.findAll();
    }

    @Override
    public ElectricMotor update(ElectricMotor motor) {
        return electricMotorRepository.save(motor);
    }

    @Override
    public void delete(Long id) {
        if(electricMotorRepository.existsById(id))
            electricMotorRepository.deleteById(id);
    }
}
