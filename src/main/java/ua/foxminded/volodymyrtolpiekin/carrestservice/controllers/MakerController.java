package ua.foxminded.volodymyrtolpiekin.carrestservice.controllers;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import ua.foxminded.volodymyrtolpiekin.carrestservice.models.dtos.MakerDTO;
import ua.foxminded.volodymyrtolpiekin.carrestservice.service.MakerService;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping(path = "/api/v1/manufacturers")
public class MakerController {

    private final MakerService makerService;

    @GetMapping
    public List<MakerDTO> getManufacturersList() {
        return makerService.getAll();
    }

    @GetMapping(path = "{makerId}")
    public MakerDTO getMaker(@PathVariable("makerId") Long makerId) {
        return makerService.getById(makerId);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public MakerDTO addMaker(@RequestBody MakerDTO makerDTO) {
        return makerService.create(makerDTO);
    }

    @PutMapping
    public MakerDTO updateMaker(@RequestBody MakerDTO makerDTO) {
        return makerService.update(makerDTO);
    }

    @DeleteMapping(path = "{makerId}")
    public void deleteMaker(@PathVariable("makerId") Long makerId) {
        makerService.deleteById(makerId);
    }
}