package net.stelmaszak.homeworkcms.controller;

import net.stelmaszak.homeworkcms.entity.Article;
import net.stelmaszak.homeworkcms.entity.Author;
import net.stelmaszak.homeworkcms.entity.Category;
import net.stelmaszak.homeworkcms.repository.ArticleRepository;
import net.stelmaszak.homeworkcms.repository.AuthorRepository;
import net.stelmaszak.homeworkcms.repository.CategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.Date;

@Controller
public class InitDB {

    @Autowired
    CategoryRepository categoryRepository;
    @Autowired
    ArticleRepository articleRepository;
    @Autowired
    AuthorRepository authorRepository;

    @RequestMapping("/initDb")
    public String initDb() {
        Author a1 = new Author();
        a1.setFirstName("S.");
        a1.setLastName("King");
        Author a2 = new Author();
        a2.setFirstName("G.");
        a2.setLastName("Martin");
        Author a3 = new Author();
        a3.setFirstName("M.");
        a3.setLastName("Stel");
        Author a4 = new Author();
        a4.setFirstName("J.R.R.");
        a4.setLastName("Tolkien");
        Author a5 = new Author();
        a5.setFirstName("JK.");
        a5.setLastName("Rowlings");

        Category c1 = new Category();
        c1.setName("technology");
        c1.setDescription("tech related articles");
        Category c2 = new Category();
        c2.setName("vehicles");
        c2.setDescription("car related articles");
        Category c3 = new Category();
        c3.setName("arts&craft");
        c3.setDescription("art related articles");
        Category c4 = new Category();
        c4.setName("showbusiness");
        c4.setDescription("showbiz related articles");
        Category c5 = new Category();
        c5.setName("sports");
        c5.setDescription("sports related articles");

        Date created = new Date();

        Article article1 = new Article();
        article1.setTitle("The title of article 1.");
        article1.setAuthor(a1);
        article1.setContent("This is the content of the article1. This is the content of the article1. This is the content of the article1. This is the content of the article1. This is the content of the article1. This is the content of the article1. This is the content of the article1. This is the content of the article1. This is the content of the article1. This is the content of the article1. This is the content of the article1. This is the content of the article1. This is the content of the article1. This is the content of the article1. This is the content of the article1. This is the content of the article1. This is the content of the article1. This is the content of the article1. This is the content of the article1. This is the content of the article1. This is the content of the article1. This is the content of the article1. This is the content of the article1. This is the content of the article1. This is the content of the article1. This is the content of the article1. This is the content of the article1. This is the content of the article1. This is the content of the article1. This is the content of the article1. This is the content of the article1. This is the content of the article1. This is the content of the article1. This is the content of the article1. This is the content of the article1. This is the content of the article1. This is the content of the article1. This is the content of the article1. This is the content of the article1. This is the content of the article1. ");
        article1.setCreated(created);
        Article article2 = new Article();
        article2.setTitle("The title of article 2.");
        article2.setAuthor(a2);
        article2.setContent("This is the content of the article1. This is the content of the article1. This is the content of the article1. This is the content of the article1. This is the content of the article1. This is the content of the article1. This is the content of the article1. This is the content of the article1. This is the content of the article1. This is the content of the article1. This is the content of the article1. This is the content of the article1. This is the content of the article1. This is the content of the article1. This is the content of the article1. This is the content of the article1. This is the content of the article1. This is the content of the article1. This is the content of the article1. This is the content of the article1. This is the content of the article1. This is the content of the article1. This is the content of the article1. This is the content of the article1. This is the content of the article1. This is the content of the article1. This is the content of the article1. This is the content of the article1. This is the content of the article1. This is the content of the article1. This is the content of the article1. This is the content of the article1. This is the content of the article1. This is the content of the article1. This is the content of the article1. This is the content of the article1. This is the content of the article1. This is the content of the article1. This is the content of the article1. This is the content of the article1. ");
        article2.setCreated(created);
        Article article3 = new Article();
        article3.setTitle("The title of article 3.");
        article3.setAuthor(a3);
        article3.setContent("This is the content of the article3. This is the content of the article3. This is the content of the article3. This is the content of the article3. This is the content of the article3. This is the content of the article3. This is the content of the article3. This is the content of the article3. This is the content of the article3. This is the content of the article3. This is the content of the article3. This is the content of the article3. This is the content of the article3. This is the content of the article3. This is the content of the article3. This is the content of the article3. This is the content of the article3. This is the content of the article3. This is the content of the article3. This is the content of the article3. This is the content of the article3. This is the content of the article3. This is the content of the article3. This is the content of the article3. This is the content of the article3. This is the content of the article3. This is the content of the article3. This is the content of the article3. This is the content of the article3. This is the content of the article3. This is the content of the article3. This is the content of the article3. This is the content of the article3. This is the content of the article3. This is the content of the article3. This is the content of the article3. This is the content of the article3. This is the content of the article3. This is the content of the article3. This is the content of the article3. ");
        article3.setCreated(created);
        Article article4 = new Article();
        article4.setTitle("The title of article 4.");
        article4.setAuthor(a4);
        article4.setContent("This is the content of the article4. This is the content of the article4. This is the content of the article4. This is the content of the article4. This is the content of the article4. This is the content of the article4. This is the content of the article4. This is the content of the article4. This is the content of the article4. This is the content of the article4. This is the content of the article4. This is the content of the article4. This is the content of the article4. This is the content of the article4. This is the content of the article4. This is the content of the article4. This is the content of the article4. This is the content of the article4. This is the content of the article4. This is the content of the article4. This is the content of the article4. This is the content of the article4. This is the content of the article4. This is the content of the article4. This is the content of the article4. This is the content of the article4. This is the content of the article4. This is the content of the article4. This is the content of the article4. This is the content of the article4. This is the content of the article4. This is the content of the article4. This is the content of the article4. This is the content of the article4. This is the content of the article4. This is the content of the article4. This is the content of the article4. This is the content of the article4. This is the content of the article4. This is the content of the article4. ");
        article4.setCreated(created);
        Article article5 = new Article();
        article5.setTitle("The title of article 5.");
        article5.setAuthor(a5);
        article5.setContent("This is the content of the article5. This is the content of the article5. This is the content of the article5. This is the content of the article5. This is the content of the article5. This is the content of the article5. This is the content of the article5. This is the content of the article5. This is the content of the article5. This is the content of the article5. This is the content of the article5. This is the content of the article5. This is the content of the article5. This is the content of the article5. This is the content of the article5. This is the content of the article5. This is the content of the article5. This is the content of the article5. This is the content of the article5. This is the content of the article5. This is the content of the article5. This is the content of the article5. This is the content of the article5. This is the content of the article5. This is the content of the article5. This is the content of the article5. This is the content of the article5. This is the content of the article5. This is the content of the article5. This is the content of the article5. This is the content of the article5. This is the content of the article5. This is the content of the article5. This is the content of the article5. This is the content of the article5. This is the content of the article5. This is the content of the article5. This is the content of the article5. This is the content of the article5. This is the content of the article5. ");
        article5.setCreated(created);
        Article article6 = new Article();
        article6.setTitle("The title of article 6.");
        article6.setAuthor(a1);
        article6.setContent("This is the content of the article6. This is the content of the article6. This is the content of the article6. This is the content of the article6. This is the content of the article6. This is the content of the article6. This is the content of the article6. This is the content of the article6. This is the content of the article6. This is the content of the article6. This is the content of the article6. This is the content of the article6. This is the content of the article6. This is the content of the article6. This is the content of the article6. This is the content of the article6. This is the content of the article6. This is the content of the article6. This is the content of the article6. This is the content of the article6. This is the content of the article6. This is the content of the article6. This is the content of the article6. This is the content of the article6. This is the content of the article6. This is the content of the article6. This is the content of the article6. This is the content of the article6. This is the content of the article6. This is the content of the article6. This is the content of the article6. This is the content of the article6. This is the content of the article6. This is the content of the article6. This is the content of the article6. This is the content of the article6. This is the content of the article6. This is the content of the article6. This is the content of the article6. This is the content of the article6. ");
        article6.setCreated(created);
        Article article7 = new Article();
        article7.setTitle("The title of article 7.");
        article7.setAuthor(a1);
        article7.setContent("This is the content of the article7. This is the content of the article7. This is the content of the article7. This is the content of the article7. This is the content of the article7. This is the content of the article7. This is the content of the article7. This is the content of the article7. This is the content of the article7. This is the content of the article7. This is the content of the article7. This is the content of the article7. This is the content of the article7. This is the content of the article7. This is the content of the article7. This is the content of the article7. This is the content of the article7. This is the content of the article7. This is the content of the article7. This is the content of the article7. This is the content of the article7. This is the content of the article7. This is the content of the article7. This is the content of the article7. This is the content of the article7. This is the content of the article7. This is the content of the article7. This is the content of the article7. This is the content of the article7. This is the content of the article7. This is the content of the article7. This is the content of the article7. This is the content of the article7. This is the content of the article7. This is the content of the article7. This is the content of the article7. This is the content of the article7. This is the content of the article7. This is the content of the article7. This is the content of the article7. ");
        article7.setCreated(created);
        Article article8 = new Article();
        article8.setTitle("The title of article 8.");
        article8.setAuthor(a2);
        article8.setContent("This is the content of the article8. This is the content of the article8. This is the content of the article8. This is the content of the article8. This is the content of the article8. This is the content of the article8. This is the content of the article8. This is the content of the article8. This is the content of the article8. This is the content of the article8. This is the content of the article8. This is the content of the article8. This is the content of the article8. This is the content of the article8. This is the content of the article8. This is the content of the article8. This is the content of the article8. This is the content of the article8. This is the content of the article8. This is the content of the article8. This is the content of the article8. This is the content of the article8. This is the content of the article8. This is the content of the article8. This is the content of the article8. This is the content of the article8. This is the content of the article8. This is the content of the article8. This is the content of the article8. This is the content of the article8. This is the content of the article8. This is the content of the article8. This is the content of the article8. This is the content of the article8. This is the content of the article8. This is the content of the article8. This is the content of the article8. This is the content of the article8. This is the content of the article8. This is the content of the article8. ");
        article8.setCreated(created);
        Article article9 = new Article();
        article9.setTitle("The title of article 9.");
        article9.setAuthor(a3);
        article9.setContent("This is the content of the article9. This is the content of the article9. This is the content of the article9. This is the content of the article9. This is the content of the article9. This is the content of the article9. This is the content of the article9. This is the content of the article9. This is the content of the article9. This is the content of the article9. This is the content of the article9. This is the content of the article9. This is the content of the article9. This is the content of the article9. This is the content of the article9. This is the content of the article9. This is the content of the article9. This is the content of the article9. This is the content of the article9. This is the content of the article9. This is the content of the article9. This is the content of the article9. This is the content of the article9. This is the content of the article9. This is the content of the article9. This is the content of the article9. This is the content of the article9. This is the content of the article9. This is the content of the article9. This is the content of the article9. This is the content of the article9. This is the content of the article9. This is the content of the article9. This is the content of the article9. This is the content of the article9. This is the content of the article9. This is the content of the article9. This is the content of the article9. This is the content of the article9. This is the content of the article9. ");
        article9.setCreated(created);
        Article article10 = new Article();
        article10.setTitle("The title of article 10.");
        article10.setAuthor(a4);
        article10.setContent("This is the content of the article10. This is the content of the article10. This is the content of the article10. This is the content of the article10. This is the content of the article10. This is the content of the article10. This is the content of the article10. This is the content of the article10. This is the content of the article10. This is the content of the article10. This is the content of the article10. This is the content of the article10. This is the content of the article10. This is the content of the article10. This is the content of the article10. This is the content of the article10. This is the content of the article10. This is the content of the article10. This is the content of the article10. This is the content of the article10. This is the content of the article10. This is the content of the article10. This is the content of the article10. This is the content of the article10. This is the content of the article10. This is the content of the article10. This is the content of the article10. This is the content of the article10. This is the content of the article10. This is the content of the article10. This is the content of the article10. This is the content of the article10. This is the content of the article10. This is the content of the article10. This is the content of the article10. This is the content of the article10. This is the content of the article10. This is the content of the article10. This is the content of the article10. This is the content of the article10. ");
        article10.setCreated(created);
        Article article11 = new Article();
        article11.setTitle("The title of article 11.");
        article11.setAuthor(a5);
        article11.setContent("This is the content of the article11. This is the content of the article11. This is the content of the article11. This is the content of the article11. This is the content of the article11. This is the content of the article11. This is the content of the article11. This is the content of the article11. This is the content of the article11. This is the content of the article11. This is the content of the article11. This is the content of the article11. This is the content of the article11. This is the content of the article11. This is the content of the article11. This is the content of the article11. This is the content of the article11. This is the content of the article11. This is the content of the article11. This is the content of the article11. This is the content of the article11. This is the content of the article11. This is the content of the article11. This is the content of the article11. This is the content of the article11. This is the content of the article11. This is the content of the article11. This is the content of the article11. This is the content of the article11. This is the content of the article11. This is the content of the article11. This is the content of the article11. This is the content of the article11. This is the content of the article11. This is the content of the article11. This is the content of the article11. This is the content of the article11. This is the content of the article11. This is the content of the article11. This is the content of the article11. ");
        article11.setCreated(created);

        authorRepository.save(a1);
        authorRepository.save(a2);
        authorRepository.save(a3);
        authorRepository.save(a4);
        authorRepository.save(a5);

        categoryRepository.save(c1);
        categoryRepository.save(c2);
        categoryRepository.save(c3);
        categoryRepository.save(c4);
        categoryRepository.save(c5);

        article1.addCategory(c1);
        article1.addCategory(c2);
        article2.addCategory(c3);
        article2.addCategory(c2);
        article3.addCategory(c4);
        article3.addCategory(c5);
        article4.addCategory(c4);
        article4.addCategory(c5);
        article5.addCategory(c3);
        article5.addCategory(c1);
        article6.addCategory(c1);
        article6.addCategory(c2);
        article7.addCategory(c3);
        article7.addCategory(c4);
        article8.addCategory(c4);
        article8.addCategory(c3);
        article9.addCategory(c4);
        article9.addCategory(c3);
        article10.addCategory(c3);
        article10.addCategory(c4);
        article11.addCategory(c1);
        article11.addCategory(c5);

        articleRepository.save(article1);
        articleRepository.save(article2);
        articleRepository.save(article3);
        articleRepository.save(article4);
        articleRepository.save(article5);
        articleRepository.save(article6);
        articleRepository.save(article7);
        articleRepository.save(article8);
        articleRepository.save(article9);
        articleRepository.save(article10);
        articleRepository.save(article11);

        return "redirect:articles";
    }

}
