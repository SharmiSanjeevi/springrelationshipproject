package com.gamestore.service;

import com.gamestore.exceptions.CategoryNotFoundException;
import com.gamestore.exceptions.RequirementNotFoundException;
import com.gamestore.model.Category;
import com.gamestore.model.CategoryName;
import com.gamestore.repository.ICategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CategoryServiceImpl implements ICategoryService {

    @Autowired
    ICategoryRepository categoryRepository;

    @Override
    public Category addCategory(Category category) {
        return categoryRepository.save(category);
    }

    @Override
    public Category updateCategory(Category category) {
        return categoryRepository.save(category);
    }

    @Override
    public void deleteCategory(int categoryId) {

        categoryRepository.deleteById(categoryId);
    }

    @Override
    public Category getById(int categoryId) throws CategoryNotFoundException {
        return categoryRepository.findById(categoryId).orElseThrow(() -> new CategoryNotFoundException("Invalid Id"));
    }

    @Override
    public List<Category> getAll() {
        return categoryRepository.findAll();
    }

    @Override
    public List<Category> getByCategory(String categoryName) throws CategoryNotFoundException {
        List<Category> category = categoryRepository.findByName(CategoryName.valueOf(categoryName.toUpperCase()));
        if (category.isEmpty()) {
            throw new RequirementNotFoundException("Category not Found");
        }
        return category;
    }
}

