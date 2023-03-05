package ua.foxminded.volodymyrtolpiekin.carrestservice.controllers;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import ua.foxminded.volodymyrtolpiekin.carrestservice.models.dtos.CarModelDTO;
import ua.foxminded.volodymyrtolpiekin.carrestservice.service.CarModelService;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping(path="/api/v1/manufacturers/model")
public class ModelController {
    private final CarModelService carModelService;

    @GetMapping
    public List<CarModelDTO> getAllModels() {
        return  carModelService.getAll();
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public CarModelDTO createCarModel(@RequestBody CarModelDTO carModelDTO) {
        return carModelService.create(carModelDTO);
    }

    @DeleteMapping(path = "{carModelId}")
    public void deleteCarModel(@PathVariable("carModelId") Long carModelId) {
        carModelService.deleteById(carModelId);
    }

    @GetMapping(path = "{carModelId}")
    public CarModelDTO getCarModel(@PathVariable("carModelId") Long carModelId) {
        return carModelService.getById(carModelId);
    }

    @PutMapping
    public CarModelDTO updateCarModel(@RequestBody CarModelDTO carModelDTO) {
        return carModelService.update(carModelDTO);
    }
}
