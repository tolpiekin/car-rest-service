package ua.foxminded.volodymyrtolpiekin.carrestservice.controllers;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import ua.foxminded.volodymyrtolpiekin.carrestservice.models.dtos.CarDTO;
import ua.foxminded.volodymyrtolpiekin.carrestservice.models.dtos.CarModelDTO;
import ua.foxminded.volodymyrtolpiekin.carrestservice.models.dtos.MakerDTO;
import ua.foxminded.volodymyrtolpiekin.carrestservice.service.CarModelService;
import ua.foxminded.volodymyrtolpiekin.carrestservice.service.CarService;
import ua.foxminded.volodymyrtolpiekin.carrestservice.service.MakerService;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping(path = "/api/v1/")
public class CarController {
    private final MakerService makerService;
    private final CarModelService carModelService;
    private final CarService carService;

    @GetMapping(path = "manufacturers")
    public List<MakerDTO> getAllModels() {
        return makerService.getAll();
    }

    @GetMapping(path = "manufacturers/{manufacturerName}")
    public List<CarModelDTO> getModelsByManufacturer(@PathVariable String manufacturerName) {
        return makerService.getAll(manufacturerName);
    }

    @GetMapping(path = "manufacturers/{manufacturerName}/models/{modelName}/{year}")
    public List<CarDTO> getCarModelByMakerModelAndYear(@PathVariable String manufacturerName, String modelName, int year) {
        return carService.getByManufacturerAndYear(manufacturerName, modelName, year);
    }
}
