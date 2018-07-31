package net.stelmaszak.homeworkcms.controller;

import net.stelmaszak.homeworkcms.dao.EntityDao;
import net.stelmaszak.homeworkcms.entity.Article;
import net.stelmaszak.homeworkcms.entity.Author;
import net.stelmaszak.homeworkcms.entity.Category;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;

@Controller
public class ArticleController {

    @Autowired
    private EntityDao entityDao;

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
        article.setUpdated(new Date().toString());
        entityDao.updateEntity(article);
        List<Category> categoryList = entityDao.loadAllCategories();
        model.addAttribute("categories", categoryList);
        List<Article> articleList = entityDao.loadAllArticles();
        model.addAttribute("articles", articleList);
        return "artpanel";
    }


}
