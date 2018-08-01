package net.stelmaszak.homeworkcms.controller;

import net.stelmaszak.homeworkcms.dao.EntityDao;
import net.stelmaszak.homeworkcms.entity.Article;
import net.stelmaszak.homeworkcms.entity.Author;
import net.stelmaszak.homeworkcms.entity.Category;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.CustomCollectionEditor;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.*;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
public class ArticleController {

    private Map<String, Category> categoryCache;

    @Autowired
    private EntityDao entityDao;

    @InitBinder
    public void initBinder(WebDataBinder binder) {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss.SSS");
        sdf.setLenient(true);
        binder.registerCustomEditor(Date.class, new CustomDateEditor(sdf, true));

        binder.registerCustomEditor(List.class, "categories", new CustomCollectionEditor(List.class) {
            protected Object convertElement(Object element) {
                if (element instanceof Category) {
                    return element;
                }
                if (element instanceof String) {
                    Category category = categoryCache.get(element);
                    return category;
                }
                return null;
            }

        });


    }

    @RequestMapping("/artpanel")
    public String showArticles(Model model) {
        List<Category> categoryList = entityDao.loadAllCategories();
        model.addAttribute("categories", categoryList);
        List<Article> articleList = entityDao.loadAllArticles();
        model.addAttribute("articles", articleList);
        return "artpanel";
    }

    @GetMapping("/editart/{id}")
    public String editArticle(Model model, @PathVariable Long id) {
        Article article = entityDao.loadArticleById(id);
        model.addAttribute("editart", article);
        List<Article> articleList = entityDao.loadAllArticles();
        model.addAttribute("articles", articleList);
        List<Category> categoryList = entityDao.loadAllCategories();
        categoryCache = new HashMap<>();
        for (Category c : categoryList) {
            categoryCache.put(c.getId().toString(), c);
        }
        model.addAttribute("categories", categoryList);
        List<Author> authorList = entityDao.loadAllAuthors();
        for (Author a : authorList) {
            a.setFullName(a.getFirstName() + " " + a.getLastName());
        }
        model.addAttribute("authors", authorList);
        return "artpanel";
    }

    @PostMapping("/editart/{id}")
    public String editArticlePost(Model model, @ModelAttribute Article article) {
        article.setUpdated(new Date());
        entityDao.updateEntity(article);
        List<Category> categoryList = entityDao.loadAllCategories();
        model.addAttribute("categories", categoryList);
        List<Article> articleList = entityDao.loadAllArticles();
        model.addAttribute("articles", articleList);
        return "artpanel";
    }

    @GetMapping("/addart")
    public String addArticle(Model model) {
        List<Category> categoryList = entityDao.loadAllCategories();
        categoryCache = new HashMap<>();
        for (Category c : categoryList) {
            categoryCache.put(c.getId().toString(), c);
        }
        model.addAttribute("categories", categoryList);
        List<Article> articleList = entityDao.loadAllArticles();
        model.addAttribute("articles", articleList);
        List<Author> authorList = entityDao.loadAllAuthors();
        model.addAttribute("authors", authorList);
        for (Author a : authorList) {
            a.setFullName(a.getFirstName() + " " + a.getLastName());
        }
        Article addart = new Article();
        model.addAttribute("addart", addart);
        return "artpanel";
    }

    @PostMapping("/addart")
    public String addArticlePost(Model model, @ModelAttribute Article article) {
        article.setCreated(new Date());
        entityDao.saveEntity(article);
        List<Category> categoryList = entityDao.loadAllCategories();
        model.addAttribute("categories", categoryList);
        List<Article> articleList = entityDao.loadAllArticles();
        model.addAttribute("articles", articleList);
        return "artpanel";
    }

}
