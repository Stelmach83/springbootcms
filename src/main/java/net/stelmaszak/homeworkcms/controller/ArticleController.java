package net.stelmaszak.homeworkcms.controller;

import net.stelmaszak.homeworkcms.entity.Article;
import net.stelmaszak.homeworkcms.entity.Author;
import net.stelmaszak.homeworkcms.entity.Category;
import net.stelmaszak.homeworkcms.repository.ArticleRepository;
import net.stelmaszak.homeworkcms.repository.AuthorRepository;
import net.stelmaszak.homeworkcms.repository.CategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.CustomCollectionEditor;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
public class ArticleController {

    private Map<String, Category> categoryCache;

    private Date created;

    @Autowired
    ArticleRepository articleRepository;
    @Autowired
    CategoryRepository categoryRepository;
    @Autowired
    AuthorRepository authorRepository;

    @InitBinder
    public void initBinder(WebDataBinder binder) {
//        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss.SSS");
//        sdf.setLenient(true);
//        binder.registerCustomEditor(Date.class, new CustomDateEditor(sdf, true));

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
        List<Category> categoryList = categoryRepository.findAll();
        model.addAttribute("categories", categoryList);
        List<Article> articleList = articleRepository.findAll();
        model.addAttribute("articles", articleList);
        return "artpanel";
    }

    @GetMapping("/editart/{id}")
    public String editArticle(Model model, @PathVariable Long id) {
        Article article = articleRepository.getOne(id);
        created = article.getCreated();
        model.addAttribute("editart", "true");
        model.addAttribute("article", article);
        List<Article> articleList = articleRepository.findAll();
        model.addAttribute("articles", articleList);
        List<Category> categoryList = categoryRepository.findAll();
        categoryCache = new HashMap<>();
        for (Category c : categoryList) {
            categoryCache.put(c.getId().toString(), c);
        }
        model.addAttribute("categories", categoryList);
        List<Author> authorList = authorRepository.findAll();
        for (Author a : authorList) {
            a.setFullName(a.getFirstName() + " " + a.getLastName());
        }
        model.addAttribute("authors", authorList);
        return "artpanel";
    }

    @PostMapping("/editart/{id}")
    public String editArticlePost(Model model, @Valid Article article, BindingResult result) {
        if (result.hasErrors()) {
            model.addAttribute("editart", "true");
            List<Article> articleList = articleRepository.findAll();
            model.addAttribute("articles", articleList);
            List<Category> categoryList = categoryRepository.findAll();
            categoryCache = new HashMap<>();
            for (Category c : categoryList) {
                categoryCache.put(c.getId().toString(), c);
            }
            model.addAttribute("categories", categoryList);
            List<Author> authorList = authorRepository.findAll();
            for (Author a : authorList) {
                a.setFullName(a.getFirstName() + " " + a.getLastName());
            }
            model.addAttribute("authors", authorList);
            return "artpanel";
        } else {
            article.setUpdated(new Date());
            article.setCreated(created);
            articleRepository.save(article);
            List<Category> categoryList = categoryRepository.findAll();
            model.addAttribute("categories", categoryList);
            List<Article> articleList = articleRepository.findAll();
            model.addAttribute("articles", articleList);
            return "artpanel";
        }
    }

    @GetMapping("/addart")
    public String addArticle(Model model) {
        List<Category> categoryList = categoryRepository.findAll();
        categoryCache = new HashMap<>();
        for (Category c : categoryList) {
            categoryCache.put(c.getId().toString(), c);
        }
        model.addAttribute("categories", categoryList);
        List<Article> articleList = articleRepository.findAll();
        model.addAttribute("articles", articleList);
        List<Author> authorList = authorRepository.findAll();
        model.addAttribute("authors", authorList);
        for (Author a : authorList) {
            a.setFullName(a.getFirstName() + " " + a.getLastName());
        }
        Article article = new Article();
        model.addAttribute("article", article);
        model.addAttribute("addart", "true");
        return "artpanel";
    }

    @PostMapping("/addart")
    public String addArticlePost(Model model, @Valid Article article, BindingResult result) {
        if (result.hasErrors()) {
            List<Category> categoryList = categoryRepository.findAll();
            categoryCache = new HashMap<>();
            for (Category c : categoryList) {
                categoryCache.put(c.getId().toString(), c);
            }
            model.addAttribute("categories", categoryList);
            List<Article> articleList = articleRepository.findAll();
            model.addAttribute("articles", articleList);
            List<Author> authorList = authorRepository.findAll();
            model.addAttribute("authors", authorList);
            for (Author a : authorList) {
                a.setFullName(a.getFirstName() + " " + a.getLastName());
            }
            model.addAttribute("addart", "true");
            return "artpanel";
        } else {
            article.setCreated(new Date());
            articleRepository.save(article);
            List<Category> categoryList = categoryRepository.findAll();
            model.addAttribute("categories", categoryList);
            List<Article> articleList = articleRepository.findAll();
            model.addAttribute("articles", articleList);
            return "artpanel";
        }
    }

    @RequestMapping("/deleteart/{id}")
    public String deleteArticle(Model model, @PathVariable Long id) {
        Article delArticle = articleRepository.getOne(id);
        List<Category> artCategories = categoryRepository.findAll();
        for (Category category : artCategories) {
            if (delArticle.getCategories().contains(category)) {
                delArticle.removeCategory(category);
            }
        }
        if (delArticle.getAuthor() != null) {
            delArticle.setAuthor(null);
        }
        articleRepository.delete(delArticle);
        List<Category> categoryList = categoryRepository.findAll();
        model.addAttribute("categories", categoryList);
        List<Article> articleList = articleRepository.findAll();
        model.addAttribute("articles", articleList);
        return "artpanel";
    }

}
