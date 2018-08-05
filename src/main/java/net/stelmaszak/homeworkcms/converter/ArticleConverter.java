package net.stelmaszak.homeworkcms.converter;

import net.stelmaszak.homeworkcms.entity.Article;
import net.stelmaszak.homeworkcms.repository.ArticleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.converter.Converter;

public class ArticleConverter implements Converter<String, Article> {

    @Autowired
    ArticleRepository articleRepository;

    @Override
    public Article convert(String s) {
        Article article = articleRepository.getOne(Long.parseLong(s));
        return article;
    }
}
