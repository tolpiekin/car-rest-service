package ua.foxminded.volodymyrtolpiekin.carrestservice.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ua.foxminded.volodymyrtolpiekin.carrestservice.models.Maker;

import java.util.Optional;

public interface MakerRepository extends JpaRepository<Maker, Long> {
    boolean existsByName(String manufacturerName);

    Optional<Maker> findByName(String manufacturerName);
}