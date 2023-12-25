package com.contoh.crudbuku.controller;

import com.contoh.crudbuku.entity.Category;
import com.contoh.crudbuku.service.CategoryService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class CategoryController {
    private CategoryService categoryService;

    public CategoryController(CategoryService categoryService) {
        this.categoryService = categoryService;
    }

    @GetMapping("/app/sukaperpus/categories")
    public String listCategories(Model model) {
        model.addAttribute("categories", categoryService.getAllCategories());
        return "categories";
    }

    @GetMapping("/app/sukaperpus/categories/new")
    public String createCategoryForm(Model model) {
        Category category = new Category();
        model.addAttribute("category", category);
        return "create_category";
    }

    @PostMapping("/app/sukaperpus/categories")
    public String saveCategory(@ModelAttribute("category") Category category) {
        categoryService.saveCategory(category);
        return "redirect:/app/sukaperpus/categories";
    }

    @GetMapping("/app/sukaperpus/categories/edit/{id}")
    public String editCategoryForm(@PathVariable Long id, Model model) {
        model.addAttribute("category", categoryService.getCategoryById(id));
        return "edit_category";
    }

    @PostMapping("/app/sukaperpus/categories/{id}")
    public String updateCategory(@PathVariable Long id, @ModelAttribute("category") Category category) {
        Category existingCategory = categoryService.getCategoryById(id);
        existingCategory.setName(category.getName());
        categoryService.updateCategory(existingCategory);
        return "redirect:/app/sukaperpus/categories";
    }

    @GetMapping("/app/sukaperpus/categories/{id}")
    public String deleteCategory(@PathVariable Long id) {
        categoryService.deleteCategoryById(id);
        return "redirect:/app/sukaperpus/categories";
    }
}