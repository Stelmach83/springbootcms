package net.stelmaszak.homeworkcms.repository;

import net.stelmaszak.homeworkcms.entity.Article;
import net.stelmaszak.homeworkcms.entity.Author;
import net.stelmaszak.homeworkcms.entity.Category;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ArticleRepository extends JpaRepository<Article, Long> {

    List<Article> findArticlesByCategories(Category category);

    List<Article> findFirst5ByOrderByCreatedDesc();

    List<Article> findAllByAuthor(Author author);



}
