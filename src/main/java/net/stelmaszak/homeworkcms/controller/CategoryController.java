package net.stelmaszak.homeworkcms.controller;

import net.stelmaszak.homeworkcms.dao.EntityDao;
import net.stelmaszak.homeworkcms.entity.Article;
import net.stelmaszak.homeworkcms.entity.Category;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

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
        Category editcat = entityDao.loadCategoryById(id);
        model.addAttribute("editcat", editcat);
        return "categories";
    }

    @PostMapping("/editcat/{id}")
    public String editCatPost(Model model, @ModelAttribute Category editcat) {
        entityDao.updateEntity(editcat);
        List<Category> categoryList = entityDao.loadAllCategories();
        model.addAttribute("categories", categoryList);
        return "categories";
    }

    @GetMapping("/addcat")
    public String addCat(Model model) {
        List<Category> categoryList = entityDao.loadAllCategories();
        model.addAttribute("categories", categoryList);
        Category addcat = new Category();
        model.addAttribute("addcat", addcat);
        return "categories";
    }

    @PostMapping("/addcat")
    public String saveCat(Model model, @ModelAttribute Category addcat) {
        entityDao.saveEntity(addcat);
        List<Category> categoryList = entityDao.loadAllCategories();
        model.addAttribute("categories", categoryList);
        return "categories";
    }

    @RequestMapping("/delcat/{id}")
    public String delCat(Model model, @PathVariable Long id) {
        Category delcat = entityDao.loadCategoryById(id);
        List<Article> articleList = delcat.getArticles();
        for (Article a : articleList) {
            a.removeCategory(delcat);
        }
        entityDao.deleteEntity(delcat);
        List<Category> categoryList = entityDao.loadAllCategories();
        model.addAttribute("categories", categoryList);
        return "categories";
    }

}
