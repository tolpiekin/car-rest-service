package ua.foxminded.volodymyrtolpiekin.carrestservice.service;

import ua.foxminded.volodymyrtolpiekin.carrestservice.models.Category;
import ua.foxminded.volodymyrtolpiekin.carrestservice.models.dtos.CategoryDTO;

import java.util.List;

public interface CategoryService {

    Category create(Category category);

    CategoryDTO create(CategoryDTO categoryDTO);

    Category findById(Long id);

    CategoryDTO getById(Long id);

    Category findByName(String name);

    CategoryDTO getByName(String name);

    List<Category> findAll();

    List<CategoryDTO> getAll();

    Category update(Category category);

    CategoryDTO update(CategoryDTO categoryDTO);

    void deleteById(Long id);

    boolean ifExistByName(String category);
}
