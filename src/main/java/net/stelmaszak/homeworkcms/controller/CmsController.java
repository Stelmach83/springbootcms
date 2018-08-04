package net.stelmaszak.homeworkcms.controller;

import net.stelmaszak.homeworkcms.dao.EntityDao;
import net.stelmaszak.homeworkcms.entity.Article;
import net.stelmaszak.homeworkcms.entity.Category;
import net.stelmaszak.homeworkcms.repository.ArticleRepository;
import net.stelmaszak.homeworkcms.repository.CategoryRepository;
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
    @Autowired
    ArticleRepository articleRepository;
    @Autowired
    CategoryRepository categoryRepository;

    @RequestMapping({"/", "/articles"})
    public String articles(Model model) {
        List<Article> articleList = articleRepository.findFirst5ByOrderByCreatedDesc();
        shorterContent(articleList);
        List<Category> categoryList = categoryRepository.findAll();
        model.addAttribute("articles", articleList);
        model.addAttribute("categories", categoryList);
        return "articles";
    }


    @RequestMapping("/articles/{cat}")
    public String articlesByCat(Model model, @PathVariable String cat) {
        Category category = categoryRepository.findByName(cat);
        List<Article> articleList = articleRepository.findArticlesByCategories(category);
        shorterContent(articleList);
        List<Category> categoryList = categoryRepository.findAll();
        model.addAttribute("articles", articleList);
        model.addAttribute("categories", categoryList);
        model.addAttribute("category", category);
        return "articles";
    }

    @RequestMapping("/article/{id}")
    public String loadArticle(Model model, @PathVariable Long id) {
        List<Category> categoryList = categoryRepository.findAll();
        Article article = articleRepository.getOne(id);
        model.addAttribute("artic", article);
        model.addAttribute("categories", categoryList);
        return "article";
    }

    private void shorterContent(List<Article> articleList) {
        for (Article a : articleList) {
            if (a.getContent().length() > 199) {
                String shortCont = a.getContent().substring(0, 200) + "..";
                entityDao.detachEntity(a);
                a.setContent(shortCont);
            }
        }
    }
}
