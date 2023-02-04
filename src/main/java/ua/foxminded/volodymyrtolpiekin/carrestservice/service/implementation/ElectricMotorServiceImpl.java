package ua.foxminded.volodymyrtolpiekin.carrestservice.service.implementation;

import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;
import ua.foxminded.volodymyrtolpiekin.carrestservice.models.ElectricMotor;
import ua.foxminded.volodymyrtolpiekin.carrestservice.models.dtos.ElectricMotorDTO;
import ua.foxminded.volodymyrtolpiekin.carrestservice.repository.ElectricMotorRepository;
import ua.foxminded.volodymyrtolpiekin.carrestservice.service.ElectricMotorService;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class ElectricMotorServiceImpl implements ElectricMotorService {

    ElectricMotorRepository electricMotorRepository;
    ModelMapper mapper;
    @Override
    public ElectricMotor create(ElectricMotor motor) {
        return electricMotorRepository.save(motor);
    }

    @Override
    public ElectricMotorDTO create(ElectricMotorDTO motorDTO) {
        ElectricMotor motor = mapper.map(motorDTO, ElectricMotor.class);
        return mapper.map(create(motor), ElectricMotorDTO.class);
    }

    @Override
    public ElectricMotor findById(Long id) {
        return electricMotorRepository.findById(id).orElseThrow(() ->
                new ResponseStatusException(HttpStatus.NOT_FOUND, "Electric Motor not found"));
    }

    @Override
    public ElectricMotorDTO getById(Long id) {
        return mapper.map(findById(id), ElectricMotorDTO.class);
    }

    @Override
    public List<ElectricMotor> findAll() {
        return electricMotorRepository.findAll();
    }

    @Override
    public List<ElectricMotorDTO> getAll() {
        return findAll()
                .stream()
                .map(motor -> mapper.map(motor, ElectricMotorDTO.class))
                .collect(Collectors.toList());
    }

    @Override
    public ElectricMotor update(ElectricMotor motor) {
        return electricMotorRepository.save(motor);
    }

    @Override
    public ElectricMotorDTO update(ElectricMotorDTO motorDTO) {
        ElectricMotor motor = mapper.map(motorDTO, ElectricMotor.class);
        return mapper.map(update(motor), ElectricMotorDTO.class);
    }

    @Override
    public void delete(Long id) {
        if(electricMotorRepository.existsById(id))
            electricMotorRepository.deleteById(id);
    }
}
