package com.gamestore.controllers;

import com.gamestore.exceptions.CategoryNotFoundException;
import com.gamestore.model.Category;
import com.gamestore.service.ICategoryService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("category-api")
public class CategoryController {

    ICategoryService categoryService;
    private Logger logger = LoggerFactory.getLogger(CategoryController.class);

    @Autowired
    public void setCategoryService(ICategoryService categoryService) {
        this.categoryService = categoryService;
    }

    /**
     * Add a new Category
     * @param category
     * @return category
     */
    @PostMapping("/category")
    public ResponseEntity<Category> addCategory(@RequestBody Category category) {
        logger.debug("inside Add Category method");
        HttpHeaders headers = new HttpHeaders();
        headers.add("desc", "Added new Category");
        Category ncategory = categoryService.addCategory(category);
        logger.info("Category Added");
        return ResponseEntity.status(HttpStatus.CREATED).body(ncategory);

    }

    /**
     * Update a category in the database
     * @param category
     * @return Category
     */

    @PutMapping("/category")
    public ResponseEntity<Category> updateCategory(@RequestBody Category category) {
        logger.debug("Update Category method");
        HttpHeaders headers = new HttpHeaders();
        headers.add("desc", "updated new Category");
        Category category1 = categoryService.updateCategory(category);
        logger.info("Category updated ");
        return ResponseEntity.status(HttpStatus.ACCEPTED).headers(headers).body(category1);

    }

    /**
     * Delete a Category
     * @param categoryId
     * @return
     */

    @DeleteMapping("/category/{categoryId}")
    public ResponseEntity<Void> deleteCategory(@PathVariable("categoryId") int categoryId) {
        logger.debug("Delete Category method");
        HttpHeaders headers = new HttpHeaders();
        headers.add("desc", "deleted new Category");
        categoryService.deleteCategory(categoryId);
        logger.info("Category deleted");
        return ResponseEntity.status(HttpStatus.ACCEPTED).headers(headers).build();
    }

    /**
     * Find Category by Id
     * @param categoryId
     * @return Category
     */
    @GetMapping("/category/id/{categoryId}")
    public ResponseEntity<Category> getById(@PathVariable("categoryId") int categoryId) {
        logger.debug("inside get category by id method");
        HttpHeaders headers = new HttpHeaders();
        headers.add("desc", "Getting Category By Id");
        Category category = categoryService.getById(categoryId);
        logger.info("Get One Property");
        return ResponseEntity.ok().headers(headers).body(category);
    }

    /**
     * Find all Category
     * @return Category
     */
    @GetMapping("/category")
    public ResponseEntity<List<Category>> getAll() {
        HttpHeaders headers = new HttpHeaders();
        headers.add("desc", "Getting All Categories");
        headers.add("info", "Category details");
        List<Category> categories = categoryService.getAll();
        ResponseEntity<List<Category>> categoryResponse = new ResponseEntity<>(categories, headers, HttpStatus.OK);
        return categoryResponse;
    }
}
