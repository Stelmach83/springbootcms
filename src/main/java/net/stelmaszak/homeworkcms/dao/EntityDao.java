package net.stelmaszak.homeworkcms.dao;

import net.stelmaszak.homeworkcms.entity.Article;
import net.stelmaszak.homeworkcms.entity.Author;
import net.stelmaszak.homeworkcms.entity.Category;
import net.stelmaszak.homeworkcms.entity.InterfaceEntity;
import org.springframework.stereotype.Component;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.transaction.Transactional;
import java.util.List;

@Component
@Transactional
public class EntityDao {

    @PersistenceContext
    EntityManager entityManager;

    public void saveEntity(InterfaceEntity entity) {
        entityManager.persist(entity);
    }

    public void updateEntity(InterfaceEntity entity) {
        entityManager.merge(entity);
    }

    public Article loadArticleById(Long id) {
        Article loaded = entityManager.find(Article.class, id);
        return loaded;
    }

    public Author loadAuthorById(Long id) {
        Author loaded = entityManager.find(Author.class, id);
        return loaded;
    }

    public Category loadCategoryById(Long id) {
        Category loaded = entityManager.find(Category.class, id);
        return loaded;
    }

    public void deleteEntity(InterfaceEntity entity) {
        entityManager.remove(entityManager.contains(entity) ? entity : entityManager.merge(entity));
    }

    public void detachEntity(InterfaceEntity entity) {
        entityManager.detach(entity);
    }

    public List<Article> loadAllArticles() {
        Query query = entityManager.createQuery("SELECT art FROM Article art");
        List<Article> articleList = query.getResultList();
        return articleList;
    }

    public List<Article> loadSomeArticles(int limit) {
        Query query = entityManager.createQuery("SELECT art FROM Article art ORDER BY art.created ASC");
        List<Article> articleList = query.setMaxResults(limit).getResultList();
        return articleList;
    }

    public List<Category> loadAllCategories() {
        Query query = entityManager.createQuery("SELECT cat FROM Category cat");
        List<Category> categoryList = query.getResultList();
        return categoryList;
    }

    public Category loadCategoryByName(String name) {
        Query query = entityManager.createQuery("SELECT cat FROM Category cat WHERE cat.name = :name");
        query.setParameter("name", name);
        Category category = (Category) query.getSingleResult();
        return category;
    }

    public List<Article> loadArticlesByAuthor(Author author) {
        Query query = entityManager.createQuery("SELECT art FROM Article art WHERE art.author = :author");
        query.setParameter("author", author);
        List<Article> articleList = query.getResultList();
        return articleList;
    }

    public List<Article> loadArticlesByCategory(Category category) {
        Query query = entityManager.createQuery("SELECT distinct art FROM Article art JOIN art.categories cat JOIN cat.articles WHERE cat = :category");
        query.setParameter("category", category);
        List<Article> articleSet = query.getResultList();
        return articleSet;
    }

    public List<Author> loadAllAuthors() {
        Query query = entityManager.createQuery("SELECT auth FROM Author auth");
        List<Author> authorList = query.getResultList();
        return authorList;
    }
}
