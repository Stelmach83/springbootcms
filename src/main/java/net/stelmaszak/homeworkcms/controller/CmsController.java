package net.stelmaszak.homeworkcms.controller;

import net.stelmaszak.homeworkcms.dao.EntityDao;
import net.stelmaszak.homeworkcms.entity.Article;
import net.stelmaszak.homeworkcms.entity.Category;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
public class CmsController {

    @Autowired
    private EntityDao entityDao;

    @RequestMapping({"/", "/articles"})
    public String articles(Model model) {
        List<Article> articleList = entityDao.loadSomeArticles(5);
        for (Article a : articleList) {
            String shortCont = a.getContent().substring(0, 200) + "..";
            entityDao.detachEntity(a);
            a.setContent(shortCont);
        }
        List<Category> categoryList = entityDao.loadAllCategories();
        model.addAttribute("articles", articleList);
        model.addAttribute("categories", categoryList);
        return "articles";
    }

    @RequestMapping("/articles/{cat}")
    public String articlesByCat(Model model, @PathVariable String cat) {
        Category category = entityDao.loadCategoryByName(cat);
        List<Article> articleList = entityDao.loadArticlesByCategory(category);
        for (Article a : articleList) {
            String shortCont = a.getContent().substring(0, 200) + "..";
            entityDao.detachEntity(a);
            a.setContent(shortCont);
        }
        List<Category> categoryList = entityDao.loadAllCategories();
        model.addAttribute("articles", articleList);
        model.addAttribute("categories", categoryList);
        model.addAttribute("category", category);
        return "articles";
    }

    @RequestMapping("/article/{id}")
    public String loadArticle(Model model, @PathVariable Long id) {
        List<Category> categoryList = entityDao.loadAllCategories();
        Article article = entityDao.loadArticleById(id);
        model.addAttribute("artic", article);
        model.addAttribute("categories", categoryList);
        return "article";
    }

}
