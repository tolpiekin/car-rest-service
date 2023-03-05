package ua.foxminded.volodymyrtolpiekin.carrestservice.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ua.foxminded.volodymyrtolpiekin.carrestservice.models.CarModel;
import ua.foxminded.volodymyrtolpiekin.carrestservice.models.dtos.CarModelDTO;

import java.util.List;

public interface CarModelRepository extends JpaRepository<CarModel, Long> {
    boolean existsByName(String modelName);

    CarModel findByName(String model);

    List<CarModelDTO> findByYear(int year);
}