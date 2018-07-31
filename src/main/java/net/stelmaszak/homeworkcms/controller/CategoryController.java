package net.stelmaszak.homeworkcms.controller;

import net.stelmaszak.homeworkcms.dao.EntityDao;
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

    @GetMapping("/editcat/{name}")
    public String editCat(Model model, @PathVariable String name) {
        List<Category> categoryList = entityDao.loadAllCategories();
        model.addAttribute("categories", categoryList);
        Category editcat = entityDao.loadCategoryByName(name);
        model.addAttribute("editcat", editcat);
        return "categories";
    }

    @PostMapping("/editcat/{name}")
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

}
