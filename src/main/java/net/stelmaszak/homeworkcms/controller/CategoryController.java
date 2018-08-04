package net.stelmaszak.homeworkcms.controller;

import net.stelmaszak.homeworkcms.entity.Article;
import net.stelmaszak.homeworkcms.entity.Category;
import net.stelmaszak.homeworkcms.repository.ArticleRepository;
import net.stelmaszak.homeworkcms.repository.CategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@Controller
public class CategoryController {

    @Autowired
    CategoryRepository categoryRepository;
    @Autowired
    ArticleRepository articleRepository;

    @RequestMapping("/categories")
    public String showCategories(Model model) {
        List<Category> categoryList = categoryRepository.findAll();
        model.addAttribute("categories", categoryList);
        return "categories";
    }

    @GetMapping("/editcat/{id}")
    public String editCat(Model model, @PathVariable Long id) {
        List<Category> categoryList = categoryRepository.findAll();
        model.addAttribute("categories", categoryList);
        Category category = categoryRepository.getOne(id);
        model.addAttribute("category", category);
        model.addAttribute("editcat", "true");
        return "categories";
    }

    @PostMapping("/editcat/{id}")
    public String editCatPost(Model model, @Valid Category category, BindingResult result) {
        if (result.hasErrors()) {
            List<Category> categoryList = categoryRepository.findAll();
            model.addAttribute("categories", categoryList);
            model.addAttribute("editcat", "true");
            return "categories";
        } else {
            categoryRepository.save(category);
            List<Category> categoryList = categoryRepository.findAll();
            model.addAttribute("categories", categoryList);
            return "categories";
        }
    }

    @GetMapping("/addcat")
    public String addCat(Model model) {
        List<Category> categoryList = categoryRepository.findAll();
        model.addAttribute("categories", categoryList);
        Category category = new Category();
        model.addAttribute("category", category);
        model.addAttribute("addcat", "true");
        return "categories";
    }

    @PostMapping("/addcat")
    public String saveCat(Model model, @Valid Category addcat, BindingResult result) {
        if (result.hasErrors()) {
            List<Category> categoryList = categoryRepository.findAll();
            model.addAttribute("categories", categoryList);
            model.addAttribute("addcat", "true");
            return "categories";
        } else {
            categoryRepository.save(addcat);
            List<Category> categoryList = categoryRepository.findAll();
            model.addAttribute("categories", categoryList);
            return "categories";
        }
    }

    @RequestMapping("/delcat/{id}")
    public String delCat(Model model, @PathVariable Long id) {
        Category delcat = categoryRepository.getOne(id);
        List<Article> articleList = articleRepository.findArticlesByCategories(delcat);
        for (Article a : articleList) {
            a.removeCategory(delcat);
        }
        categoryRepository.delete(delcat);
        List<Category> categoryList = categoryRepository.findAll();
        model.addAttribute("categories", categoryList);
        return "categories";
    }

}
