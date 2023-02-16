package ua.foxminded.volodymyrtolpiekin.carrestservice.controllers;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import ua.foxminded.volodymyrtolpiekin.carrestservice.models.dtos.CarModelDTO;
import ua.foxminded.volodymyrtolpiekin.carrestservice.service.CarModelService;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping(path = "/api/v1/manufacturers/model")
public class CarModelController {

    private final CarModelService carModelService;

    @GetMapping
    public List<CarModelDTO> getModelsList() {
        return carModelService.getAll();
    }

    @GetMapping(path = "{carModelId}")
    public CarModelDTO getModel(@PathVariable("CarModelId") Long carModelId) {
        return carModelService.getById(carModelId);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public CarModelDTO addModel(@RequestBody CarModelDTO carModelDTO) {
        return carModelService.create(carModelDTO);
    }

    @PutMapping
    public CarModelDTO updateModel(@RequestBody CarModelDTO carModelDTO) {
        return carModelService.update(carModelDTO);
    }

    @DeleteMapping(path = "{carModelId}")
    public void deleteModel(@PathVariable("carModelId") Long carModelId) {
        carModelService.deleteById(carModelId);
    }
}
