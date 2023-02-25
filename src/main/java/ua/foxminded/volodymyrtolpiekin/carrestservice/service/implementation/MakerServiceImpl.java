package ua.foxminded.volodymyrtolpiekin.carrestservice.service.implementation;

import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;
import ua.foxminded.volodymyrtolpiekin.carrestservice.models.CarModel;
import ua.foxminded.volodymyrtolpiekin.carrestservice.models.Maker;
import ua.foxminded.volodymyrtolpiekin.carrestservice.models.dtos.CarModelDTO;
import ua.foxminded.volodymyrtolpiekin.carrestservice.models.dtos.MakerDTO;
import ua.foxminded.volodymyrtolpiekin.carrestservice.repository.MakerRepository;
import ua.foxminded.volodymyrtolpiekin.carrestservice.service.MakerService;

import java.util.List;

@Service
@RequiredArgsConstructor
public class MakerServiceImpl implements MakerService {

    private final MakerRepository makerRepository;
    private final ModelMapper mapper;

    @Override
    public Maker create(Maker maker) {
        return makerRepository.save(maker);
    }

    @Override
    public MakerDTO create(MakerDTO makerDTO) {
        Maker maker = mapper.map(makerDTO, Maker.class);
        return mapper.map(create(maker), MakerDTO.class);
    }

    @Override
    public Maker findById(Long id) {
        return makerRepository.findById(id).orElseThrow(() ->
                new ResponseStatusException(HttpStatus.NOT_FOUND, "Maker not found"));
    }

    @Override
    public MakerDTO getById(Long id) {
        return mapper.map(findById(id), MakerDTO.class);
    }

    @Override
    public List<CarModel> findAll(String name) {
        Maker maker = makerRepository.findByName(name).get();
        return maker.getCarModelList();
    }

    @Override
    public List<CarModelDTO> getAll(String name) {
        return findAll(name)
                .stream()
                .map(car -> mapper.map(car, CarModelDTO.class))
                .toList();
    }

    @Override
    public List<Maker> findAll() {
        return makerRepository.findAll();
    }

    @Override
    public List<MakerDTO> getAll() {
        return findAll()
                .stream()
                .map(maker -> mapper.map(maker, MakerDTO.class))
                .toList();
    }

    @Override
    public Maker update(Maker maker) {
        return makerRepository.save(maker);
    }

    @Override
    public MakerDTO update(MakerDTO makerDTO) {
        Maker maker = mapper.map(makerDTO, Maker.class);
        return mapper.map(update(maker), MakerDTO.class);
    }

    @Override
    public void deleteById(Long id) {
        if(makerRepository.existsById(id))
            makerRepository.deleteById(id);
    }

    @Override
    public boolean ifExistsByName(String manufacturerName) {
        return makerRepository.existsByName(manufacturerName);
    }

    @Override
    public List<CarModelDTO> getByName(String manufacturerName) {
        if (ifExistsByName(manufacturerName)) {

        }
        Maker maker = makerRepository.findByName(manufacturerName).get();
        return maker.getCarModelList()
                .stream()
                .map(model -> mapper.map(model, CarModelDTO.class))
                .toList();
    }

    @Override
    public Maker findByName(String make) {
        if(ifExistsByName(make))
            return makerRepository.findByName(make).get();
        else
            throw new ResponseStatusException(HttpStatus.NOT_FOUND,"Car Maker not found");
    }
}
