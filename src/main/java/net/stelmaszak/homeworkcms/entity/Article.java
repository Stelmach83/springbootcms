package net.stelmaszak.homeworkcms.entity;

import net.stelmaszak.homeworkcms.validator.MaxCategories;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.*;

@Entity
@Table(name = "article")
public class Article implements InterfaceEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @NotNull
    @NotEmpty
    @Size(min = 1, max = 200)
    private String title;
    @ManyToOne(fetch = FetchType.EAGER, optional = true)
    @JoinColumn(name = "author_id", nullable = true)
    @OnDelete(action = OnDeleteAction.CASCADE)
    private Author author;
    @Column(columnDefinition = "TEXT")
    @NotNull
    @NotEmpty
    @Size(min = 500)
    private String content;

    @Basic
    @Temporal(TemporalType.TIMESTAMP)
    private Date created;

    @Basic
    @Temporal(TemporalType.TIMESTAMP)
    private Date updated;

    @NotNull
    @NotEmpty
    @MaxCategories("2")
    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(name = "article_category", joinColumns = {@JoinColumn(name = "article_id")}, inverseJoinColumns = {@JoinColumn(name = "category_id")})
    private List<Category> categories = new ArrayList<>();

    public Article() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Author getAuthor() {
        return author;
    }

    public void setAuthor(Author author) {
        this.author = author;
    }

    public void removeAuthor() {
        this.author = null;
    }

    public List<Category> getCategories() {
        return categories;
    }

    public void setCategories(List<Category> categories) {
        this.categories = categories;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public Date getCreated() {
        return created;
    }

    public void setCreated(Date created) {
        this.created = created;
    }

    public Date getUpdated() {
        return updated;
    }

    public void setUpdated(Date updated) {
        this.updated = updated;
    }

    public void addCategory(Category category) {
        categories.add(category);
//        category.getArticles().add(this);
    }

    public void removeCategory(Category category) {
        categories.remove(category);
//        category.getArticles().remove(this);
    }

    @Override
    public String toString() {
        return "Article{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", author=" + author +
                ", content='" + content + '\'' +
                ", created=" + created +
                ", updated=" + updated +
                ", categories=" + categories +
                '}';
    }
}
