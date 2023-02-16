package ua.foxminded.volodymyrtolpiekin.carrestservice.service.implementation;

import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;
import ua.foxminded.volodymyrtolpiekin.carrestservice.models.TractionBattery;
import ua.foxminded.volodymyrtolpiekin.carrestservice.models.dtos.TractionBatteryDTO;
import ua.foxminded.volodymyrtolpiekin.carrestservice.repository.TractionBatteryRepository;
import ua.foxminded.volodymyrtolpiekin.carrestservice.service.TractionBatteryService;

import java.util.List;

@Service
@RequiredArgsConstructor
public class TractionBatteryServiceImpl implements TractionBatteryService {

    private final TractionBatteryRepository tractionBatteryRepository;
    private final ModelMapper mapper;

    @Override
    public TractionBattery create(TractionBattery battery) {
        return tractionBatteryRepository.save(battery);
    }

    @Override
    public TractionBatteryDTO create(TractionBatteryDTO batteryDTO) {
        TractionBattery battery = mapper.map(batteryDTO, TractionBattery.class);
        return mapper.map(create(battery), TractionBatteryDTO.class);
    }

    @Override
    public TractionBattery findById(Long id) {
        return tractionBatteryRepository.findById(id).orElseThrow(() ->
                new ResponseStatusException(HttpStatus.NOT_FOUND, "Traction Battery not found"));
    }

    @Override
    public TractionBatteryDTO getById(Long id) {
        return mapper.map(findById(id), TractionBatteryDTO.class);
    }

    @Override
    public List<TractionBattery> findAll() {
        return tractionBatteryRepository.findAll();
    }

    @Override
    public List<TractionBatteryDTO> getAll() {
        return findAll()
                .stream()
                .map(tractionBattery -> mapper.map(tractionBattery, TractionBatteryDTO.class))
                .toList();
    }

    @Override
    public TractionBattery update(TractionBattery battery) {
        return tractionBatteryRepository.save(battery);
    }

    @Override
    public TractionBatteryDTO update(TractionBatteryDTO batteryDTO) {
        TractionBattery battery = mapper.map(batteryDTO, TractionBattery.class);
        return mapper.map(update(battery), TractionBatteryDTO.class);
    }

    @Override
    public void deleteById(Long id) {
        if(tractionBatteryRepository.existsById(id))
            tractionBatteryRepository.deleteById(id);
    }
}
