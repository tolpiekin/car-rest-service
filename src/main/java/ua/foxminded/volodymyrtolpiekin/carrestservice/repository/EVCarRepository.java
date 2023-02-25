package ua.foxminded.volodymyrtolpiekin.carrestservice.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ua.foxminded.volodymyrtolpiekin.carrestservice.models.EVCar;

import java.util.Optional;

public interface EVCarRepository extends JpaRepository<EVCar, Long> {
    Optional<EVCar> findByObjectId(String objectId);
}