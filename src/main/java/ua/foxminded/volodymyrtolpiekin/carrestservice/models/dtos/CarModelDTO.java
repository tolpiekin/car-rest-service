package ua.foxminded.volodymyrtolpiekin.carrestservice.models.dtos;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import ua.foxminded.volodymyrtolpiekin.carrestservice.models.Category;
import ua.foxminded.volodymyrtolpiekin.carrestservice.models.Maker;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class CarModelDTO {
    private Long id;
    private String name;
    private Maker maker;
    private List<Category> category;
}
