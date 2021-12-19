package com.gamestore.repository;


import com.gamestore.model.Category;
import com.gamestore.model.CategoryName;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ICategoryRepository extends JpaRepository<Category, Integer> {
    List<Category> findByName(CategoryName categoryName);
}
