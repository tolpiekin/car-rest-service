package ua.foxminded.volodymyrtolpiekin.carrestservice.controllers;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import ua.foxminded.volodymyrtolpiekin.carrestservice.models.dtos.CarModelDTO;
import ua.foxminded.volodymyrtolpiekin.carrestservice.service.CarModelService;

import java.util.List;
import java.util.Set;

@RestController
@RequiredArgsConstructor
@RequestMapping(path = "/api/v1/manufacturers/model/year")
public class YearController {
    private final CarModelService carModelService;

    @GetMapping
    public Set<Integer> getAllYears() {
        return  carModelService.getAllYears();
    }

    @GetMapping(path = "{year}")
    public List<CarModelDTO> getModelsByYear(@PathVariable("year") int year) {
        return carModelService.getByYear(year);
    }
}
