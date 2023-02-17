package ua.foxminded.volodymyrtolpiekin.carrestservice.models.dtos;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class CarModelDTO {
    private Long id;
    private String name;
    private MakerDTO maker;
    private List<CategoryDTO> category;
}
