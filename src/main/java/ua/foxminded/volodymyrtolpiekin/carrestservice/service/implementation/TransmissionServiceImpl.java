package ua.foxminded.volodymyrtolpiekin.carrestservice.service.implementation;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;
import ua.foxminded.volodymyrtolpiekin.carrestservice.models.Transmission;
import ua.foxminded.volodymyrtolpiekin.carrestservice.repository.TransmissionRepository;
import ua.foxminded.volodymyrtolpiekin.carrestservice.service.TransmissionService;

import java.util.List;

@Service
@RequiredArgsConstructor
public class TransmissionServiceImpl implements TransmissionService {

    TransmissionRepository transmissionRepository;

    @Override
    public Transmission create(Transmission transmission) {
        return transmissionRepository.save(transmission);
    }

    @Override
    public Transmission getById(Long id) {
        return transmissionRepository.findById(id).orElseThrow(() ->
                new ResponseStatusException(HttpStatus.NOT_FOUND, "Transmission not found"));
    }

    @Override
    public List<Transmission> getAll() {
        return transmissionRepository.findAll();
    }

    @Override
    public Transmission update(Transmission transmission) {
        return transmissionRepository.save(transmission);
    }

    @Override
    public void deleteById(Long id) {
        if(transmissionRepository.existsById(id))
            transmissionRepository.deleteById(id);
    }
}
