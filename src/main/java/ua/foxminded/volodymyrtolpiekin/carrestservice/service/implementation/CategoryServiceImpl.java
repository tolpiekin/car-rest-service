package ua.foxminded.volodymyrtolpiekin.carrestservice.service.implementation;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;
import ua.foxminded.volodymyrtolpiekin.carrestservice.models.Category;
import ua.foxminded.volodymyrtolpiekin.carrestservice.repository.CategoryRepository;
import ua.foxminded.volodymyrtolpiekin.carrestservice.service.CategoryService;

import java.util.List;

@Service
@RequiredArgsConstructor
public class CategoryServiceImpl implements CategoryService {
    CategoryRepository categoryRepository;

    @Override
    public Category create(Category category) {
        return categoryRepository.save(category);
    }

    @Override
    public Category getById(Long id) {
        return categoryRepository.findById(id).orElseThrow(() ->
                new ResponseStatusException(HttpStatus.NOT_FOUND, "Category not found"));
    }

    @Override
    public List<Category> getAll() {
        return categoryRepository.findAll();
    }

    @Override
    public Category update(Category category) {
        return categoryRepository.save(category);
    }

    @Override
    public void deleteById(Long id) {
        if(categoryRepository.existsById(id))
            categoryRepository.deleteById(id);
    }
}
