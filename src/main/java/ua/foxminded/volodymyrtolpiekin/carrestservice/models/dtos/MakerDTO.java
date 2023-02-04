package ua.foxminded.volodymyrtolpiekin.carrestservice.models.dtos;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import ua.foxminded.volodymyrtolpiekin.carrestservice.models.CarModel;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class MakerDTO {
    private Long id;
    private String name;
    private String country;
    private List<CarModel> carModelList;
}
