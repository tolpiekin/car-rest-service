package ua.foxminded.volodymyrtolpiekin.carrestservice.service.implementation;

import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;
import ua.foxminded.volodymyrtolpiekin.carrestservice.models.Category;
import ua.foxminded.volodymyrtolpiekin.carrestservice.models.dtos.CategoryDTO;
import ua.foxminded.volodymyrtolpiekin.carrestservice.repository.CategoryRepository;
import ua.foxminded.volodymyrtolpiekin.carrestservice.service.CategoryService;

import java.util.List;

@Service
@RequiredArgsConstructor
public class CategoryServiceImpl implements CategoryService {
    private final CategoryRepository categoryRepository;
    private final ModelMapper mapper;

    @Override
    public Category create(Category category) {
        return categoryRepository.save(category);
    }

    @Override
    public CategoryDTO create(CategoryDTO categoryDTO) {
        Category category = mapper.map(categoryDTO, Category.class);
        return mapper.map(create(category), CategoryDTO.class);
    }

    @Override
    public Category findById(Long id) {
        return categoryRepository.findById(id).orElseThrow(() ->
                new ResponseStatusException(HttpStatus.NOT_FOUND, "Category not found"));
    }

    @Override
    public CategoryDTO getById(Long id) {
        return mapper.map(findById(id), CategoryDTO.class);
    }

    @Override
    public Category findByName(String name) {
        return categoryRepository.findByName(name);
    }

    @Override
    public CategoryDTO getByName(String name) {
        return mapper.map(findByName(name), CategoryDTO.class);
    }

    @Override
    public List<Category> findAll() {
        return categoryRepository.findAll();
    }

    @Override
    public List<CategoryDTO> getAll() {
        return findAll()
                .stream()
                .map(category -> mapper.map(category, CategoryDTO.class))
                .toList();
    }

    @Override
    public Category update(Category category) {
        return categoryRepository.save(category);
    }

    @Override
    public CategoryDTO update(CategoryDTO categoryDTO) {
        Category category = mapper.map(categoryDTO, Category.class);
        return mapper.map(update(category), CategoryDTO.class);
    }

    @Override
    public void deleteById(Long id) {
        if(categoryRepository.existsById(id))
            categoryRepository.deleteById(id);
    }

    @Override
    public boolean ifExistByName(String category) {
        return categoryRepository.existsByName(category);
    }
}
