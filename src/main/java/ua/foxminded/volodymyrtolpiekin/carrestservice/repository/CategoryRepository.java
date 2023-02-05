package ua.foxminded.volodymyrtolpiekin.carrestservice.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ua.foxminded.volodymyrtolpiekin.carrestservice.models.Category;

public interface CategoryRepository extends JpaRepository<Category, Long> {
    Category findByName(String name);
}