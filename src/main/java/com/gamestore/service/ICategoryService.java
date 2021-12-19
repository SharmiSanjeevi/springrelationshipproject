package com.gamestore.service;

import com.gamestore.exceptions.CategoryNotFoundException;
import com.gamestore.model.Category;

import java.util.List;

public interface ICategoryService {

    Category addCategory(Category category);

    Category updateCategory(Category category);

    void deleteCategory(int categoryId);

    Category getById(int categoryId) throws CategoryNotFoundException;

    List<Category> getAll();

    List<Category> getByCategory(String categoryName) throws CategoryNotFoundException;


}
