package ua.foxminded.volodymyrtolpiekin.carrestservice.controllers;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import ua.foxminded.volodymyrtolpiekin.carrestservice.models.dtos.MakerDTO;
import ua.foxminded.volodymyrtolpiekin.carrestservice.models.dtos.CarModelDTO;
import ua.foxminded.volodymyrtolpiekin.carrestservice.service.CarModelService;
import ua.foxminded.volodymyrtolpiekin.carrestservice.service.MakerService;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping(path= "/api/v1/manufacturers")
public class CarModelsController {
    private final MakerService makerService;
    private final CarModelService carModelService;

    @GetMapping
    public List<MakerDTO> getAllMakers() {
        return  makerService.getAll();
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public MakerDTO createMaker(@RequestBody MakerDTO makerDTO) {
        return makerService.create(makerDTO);
    }

    @DeleteMapping(path = "{makerId}")
    public void deleteMaker(@PathVariable("makerId") Long makerId) {
        makerService.deleteById(makerId);
    }

    @GetMapping(path = "{makerId}")
    public MakerDTO getMaker(@PathVariable("makerId") Long makerId) {
        return makerService.getById(makerId);
    }

    @PutMapping
    public MakerDTO updateMaker(@RequestBody MakerDTO makerDTO) {
        return makerService.update(makerDTO);
    }

    @GetMapping(path = "{makerName}/models")
    public List<CarModelDTO> getModelsForMaker(@PathVariable("makerName")String makerName) {
        return  carModelService.getMakerModels(makerName);
    }

    @PostMapping(path = "{makerName}/model/{modelName}/year/{year}")
    @ResponseStatus(HttpStatus.CREATED)
    public CarModelDTO createCarModel(@PathVariable ("makerName") String makerName,
                                      @PathVariable ("modelName") String modelName,
                                      @PathVariable ("year") int year) {
        return carModelService.create(makerName, modelName, year);
    }

    @DeleteMapping(path = "{makerName}/model/{modelName}/year/{year}")
    public void deleteCarModel(@PathVariable("makerName") String makerName,
                               @PathVariable("modelName") String modelName,
                               @PathVariable("year") int year) {
        carModelService.deleteByNameAndYear(makerName, modelName, year);
    }

    @GetMapping(path = "{makerName}/model/{modelName}/year/{year}")
    public List<CarModelDTO> getCarModel(@PathVariable("makerName") String makerName,
                                   @PathVariable("modelName") String modelName,
                                   @PathVariable("year") int year) {
        return carModelService.getByNameAndYear(makerName, modelName, year);
    }

    @PutMapping(path = "{makerName}/model/{modelName}/year/{year}")
    public CarModelDTO updateCarModel(@PathVariable("makerName") String makerName,
                                      @PathVariable("modelName") String modelName,
                                      @PathVariable("year") int year) {
        return carModelService.updateByNameAndYear(makerName, modelName, year);
    }
}
