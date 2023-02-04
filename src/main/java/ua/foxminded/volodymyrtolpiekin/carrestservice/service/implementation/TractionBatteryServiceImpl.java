package ua.foxminded.volodymyrtolpiekin.carrestservice.service.implementation;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;
import ua.foxminded.volodymyrtolpiekin.carrestservice.models.TractionBattery;
import ua.foxminded.volodymyrtolpiekin.carrestservice.repository.TractionBatteryRepository;
import ua.foxminded.volodymyrtolpiekin.carrestservice.service.TractionBatteryService;

import java.util.List;

@Service
@RequiredArgsConstructor
public class TractionBatteryServiceImpl implements TractionBatteryService {

    TractionBatteryRepository tractionBatteryRepository;

    @Override
    public TractionBattery create(TractionBattery battery) {
        return tractionBatteryRepository.save(battery);
    }

    @Override
    public TractionBattery getById(Long id) {
        return tractionBatteryRepository.findById(id).orElseThrow(() ->
                new ResponseStatusException(HttpStatus.NOT_FOUND, "Traction Battery not found"));
    }

    @Override
    public List<TractionBattery> getAll() {
        return tractionBatteryRepository.findAll();
    }

    @Override
    public TractionBattery update(TractionBattery battery) {
        return tractionBatteryRepository.save(battery);
    }

    @Override
    public void deleteById(Long id) {
        if(tractionBatteryRepository.existsById(id))
            tractionBatteryRepository.deleteById(id);
    }
}
