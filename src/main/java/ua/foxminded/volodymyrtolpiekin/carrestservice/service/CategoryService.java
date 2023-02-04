package ua.foxminded.volodymyrtolpiekin.carrestservice.service;

import ua.foxminded.volodymyrtolpiekin.carrestservice.models.Category;

import java.util.List;

public interface CategoryService {

    Category create(Category category);

    Category getById(Long id);

    List<Category> getAll();

    Category update(Category category);

    void deleteById(Long id);
}
