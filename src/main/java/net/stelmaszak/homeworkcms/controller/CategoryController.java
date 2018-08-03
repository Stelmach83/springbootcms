package net.stelmaszak.homeworkcms.controller;

import net.stelmaszak.homeworkcms.dao.EntityDao;
import net.stelmaszak.homeworkcms.entity.Article;
import net.stelmaszak.homeworkcms.entity.Category;
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
    private EntityDao entityDao;

    @RequestMapping("/categories")
    public String showCategories(Model model) {
        List<Category> categoryList = entityDao.loadAllCategories();
        model.addAttribute("categories", categoryList);
        return "categories";
    }

    @GetMapping("/editcat/{id}")
    public String editCat(Model model, @PathVariable Long id) {
        List<Category> categoryList = entityDao.loadAllCategories();
        model.addAttribute("categories", categoryList);
        Category category = entityDao.loadCategoryById(id);
        model.addAttribute("category", category);
        model.addAttribute("editcat", "true");
        return "categories";
    }

    @PostMapping("/editcat/{id}")
    public String editCatPost(Model model, @Valid Category category, BindingResult result) {
        if (result.hasErrors()) {
            List<Category> categoryList = entityDao.loadAllCategories();
            model.addAttribute("categories", categoryList);
            model.addAttribute("editcat", "true");
            return "categories";
        } else {
            entityDao.updateEntity(category);
            List<Category> categoryList = entityDao.loadAllCategories();
            model.addAttribute("categories", categoryList);
            return "categories";
        }
    }

    @GetMapping("/addcat")
    public String addCat(Model model) {
        List<Category> categoryList = entityDao.loadAllCategories();
        model.addAttribute("categories", categoryList);
        Category category = new Category();
        model.addAttribute("category", category);
        model.addAttribute("addcat", "true");
        return "categories";
    }

    @PostMapping("/addcat")
    public String saveCat(Model model, @Valid Category addcat, BindingResult result) {
        if (result.hasErrors()) {
            List<Category> categoryList = entityDao.loadAllCategories();
            model.addAttribute("categories", categoryList);
            model.addAttribute("addcat", "true");
            return "categories";
        } else {
            entityDao.saveEntity(addcat);
            List<Category> categoryList = entityDao.loadAllCategories();
            model.addAttribute("categories", categoryList);
            return "categories";
        }
    }

    @RequestMapping("/delcat/{id}")
    public String delCat(Model model, @PathVariable Long id) {
        Category delcat = entityDao.loadCategoryById(id);
        List<Article> articleList = entityDao.loadArticlesByCategory(delcat);
        for (Article a : articleList) {
            a.removeCategory(delcat);
        }
        entityDao.deleteEntity(delcat);
        List<Category> categoryList = entityDao.loadAllCategories();
        model.addAttribute("categories", categoryList);
        return "categories";
    }

}
