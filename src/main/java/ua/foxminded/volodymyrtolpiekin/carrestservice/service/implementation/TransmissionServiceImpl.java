package ua.foxminded.volodymyrtolpiekin.carrestservice.service.implementation;

import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;
import ua.foxminded.volodymyrtolpiekin.carrestservice.models.Transmission;
import ua.foxminded.volodymyrtolpiekin.carrestservice.models.dtos.TransmissionDTO;
import ua.foxminded.volodymyrtolpiekin.carrestservice.repository.TransmissionRepository;
import ua.foxminded.volodymyrtolpiekin.carrestservice.service.TransmissionService;

import java.util.List;

@Service
@RequiredArgsConstructor
public class TransmissionServiceImpl implements TransmissionService {

    private final TransmissionRepository transmissionRepository;
    private final ModelMapper mapper;

    @Override
    public Transmission create(Transmission transmission) {
        return transmissionRepository.save(transmission);
    }

    @Override
    public TransmissionDTO create(TransmissionDTO transmissionDTO) {
        Transmission transmission = mapper.map(transmissionDTO, Transmission.class);
        return mapper.map(create(transmission), TransmissionDTO.class);
    }

    @Override
    public Transmission findById(Long id) {
        return transmissionRepository.findById(id).orElseThrow(() ->
                new ResponseStatusException(HttpStatus.NOT_FOUND, "Transmission not found"));
    }

    @Override
    public TransmissionDTO getById(Long id) {
        return mapper.map(findById(id), TransmissionDTO.class);
    }

    @Override
    public List<Transmission> findAll() {
        return transmissionRepository.findAll();
    }

    @Override
    public List<TransmissionDTO> getAll() {
        return findAll()
                .stream()
                .map(transmission -> mapper.map(transmission, TransmissionDTO.class))
                .toList();
    }

    @Override
    public Transmission update(Transmission transmission) {
        return transmissionRepository.save(transmission);
    }

    @Override
    public TransmissionDTO update(TransmissionDTO transmissionDTO) {
        Transmission transmission = mapper.map(transmissionDTO, Transmission.class);
        return mapper.map(update(transmission), TransmissionDTO.class);
    }

    @Override
    public void deleteById(Long id) {
        if(transmissionRepository.existsById(id))
            transmissionRepository.deleteById(id);
    }
}
