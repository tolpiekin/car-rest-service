package ua.foxminded.volodymyrtolpiekin.carrestservice.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ua.foxminded.volodymyrtolpiekin.carrestservice.models.Car;

import java.util.Optional;

public interface CarRepository extends JpaRepository<Car, Long> {

    Optional<Car> findByObjectId(String objectId);
}