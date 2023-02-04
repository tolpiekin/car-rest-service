package ua.foxminded.volodymyrtolpiekin.carrestservice.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ua.foxminded.volodymyrtolpiekin.carrestservice.models.EVCar;

public interface EVCarRepository extends JpaRepository<EVCar, Long> {

}