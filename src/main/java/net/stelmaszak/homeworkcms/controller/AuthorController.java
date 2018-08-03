package net.stelmaszak.homeworkcms.controller;

import net.stelmaszak.homeworkcms.dao.EntityDao;
import net.stelmaszak.homeworkcms.entity.Article;
import net.stelmaszak.homeworkcms.entity.Author;
import net.stelmaszak.homeworkcms.entity.Category;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@Controller
public class AuthorController {

    @Autowired
    private EntityDao entityDao;

    @RequestMapping("/authors")
    public String showAuthors(Model model) {
        List<Author> authorList = entityDao.loadAllAuthors();
        model.addAttribute("authors", authorList);
        List<Category> categoryList = entityDao.loadAllCategories();
        model.addAttribute("categories", categoryList);
        return "authors";
    }

    @GetMapping("/editauth/{id}")
    public String editAuthor(Model model, @PathVariable Long id) {
        List<Category> categoryList = entityDao.loadAllCategories();
        model.addAttribute("categories", categoryList);
        Author author = entityDao.loadAuthorById(id);
        model.addAttribute("author", author);
        model.addAttribute("editauth", "true");
        List<Author> authorList = entityDao.loadAllAuthors();
        model.addAttribute("authors", authorList);
        return "authors";
    }

    @PostMapping("/editauth/{id}")
    public String editAuthorPost(Model model, @Valid Author author, BindingResult result) {
        if (result.hasErrors()) {
            List<Category> categoryList = entityDao.loadAllCategories();
            model.addAttribute("categories", categoryList);
            List<Author> authorList = entityDao.loadAllAuthors();
            model.addAttribute("authors", authorList);
            model.addAttribute("editauth", "true");
            return "authors";
        } else {
            entityDao.updateEntity(author);
            List<Category> categoryList = entityDao.loadAllCategories();
            model.addAttribute("categories", categoryList);
            List<Author> authorList = entityDao.loadAllAuthors();
            model.addAttribute("authors", authorList);
            return "authors";
        }
    }

    @GetMapping("/addauth")
    public String addAuthor(Model model) {
        List<Category> categoryList = entityDao.loadAllCategories();
        model.addAttribute("categories", categoryList);
        List<Author> authorList = entityDao.loadAllAuthors();
        model.addAttribute("authors", authorList);
        Author author = new Author();
        model.addAttribute("author", author);
        model.addAttribute("addauth", "true");
        return "authors";
    }

    @PostMapping("/addauth")
    public String addAuthorPost(Model model, @Valid Author author, BindingResult result) {
        if (result.hasErrors()) {
            model.addAttribute("addauth", "true");
            List<Category> categoryList = entityDao.loadAllCategories();
            model.addAttribute("categories", categoryList);
            List<Author> authorList = entityDao.loadAllAuthors();
            model.addAttribute("authors", authorList);
            return "authors";
        } else {
            entityDao.saveEntity(author);
            List<Category> categoryList = entityDao.loadAllCategories();
            model.addAttribute("categories", categoryList);
            List<Author> authorList = entityDao.loadAllAuthors();
            model.addAttribute("authors", authorList);
            return "authors";
        }
    }

    @RequestMapping("/delauth/{id}")
    public String deleteAuthor(Model model, @PathVariable Long id) {
        Author delAuthor = entityDao.loadAuthorById(id);
        List<Article> articleList = entityDao.loadArticlesByAuthor(delAuthor);
        for (Article a : articleList) {
            a.removeAuthor();
            entityDao.updateEntity(a);
        }
        entityDao.deleteEntity(delAuthor);
        List<Category> categoryList = entityDao.loadAllCategories();
        model.addAttribute("categories", categoryList);
        List<Author> authorList = entityDao.loadAllAuthors();
        model.addAttribute("authors", authorList);
        return "authors";
    }

}
