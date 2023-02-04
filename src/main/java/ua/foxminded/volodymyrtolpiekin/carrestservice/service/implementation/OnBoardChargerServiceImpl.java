package ua.foxminded.volodymyrtolpiekin.carrestservice.service.implementation;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;
import ua.foxminded.volodymyrtolpiekin.carrestservice.models.OnBoardCharger;
import ua.foxminded.volodymyrtolpiekin.carrestservice.repository.OnBoardChargerRepository;
import ua.foxminded.volodymyrtolpiekin.carrestservice.service.OnBoardChargerService;

import java.util.List;

@Service
@RequiredArgsConstructor
public class OnBoardChargerServiceImpl implements OnBoardChargerService {

    OnBoardChargerRepository onBoardChargerRepository;

    @Override
    public OnBoardCharger create(OnBoardCharger charger) {
        return onBoardChargerRepository.save(charger);
    }

    @Override
    public OnBoardCharger getById(Long id) {
        return onBoardChargerRepository.findById(id).orElseThrow(() ->
                new ResponseStatusException(HttpStatus.NOT_FOUND, "On Board Charger not found"));
    }

    @Override
    public List<OnBoardCharger> getAll() {
        return onBoardChargerRepository.findAll();
    }

    @Override
    public OnBoardCharger update(OnBoardCharger charger) {
        return onBoardChargerRepository.save(charger);
    }

    @Override
    public void deleteById(Long id) {
        if(onBoardChargerRepository.existsById(id))
            onBoardChargerRepository.deleteById(id);
    }
}
