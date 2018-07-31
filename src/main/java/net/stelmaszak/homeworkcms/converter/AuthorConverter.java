package net.stelmaszak.homeworkcms.converter;

import net.stelmaszak.homeworkcms.dao.EntityDao;
import net.stelmaszak.homeworkcms.entity.Author;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.converter.Converter;

public class AuthorConverter implements Converter<String, Author> {

    @Autowired
    private EntityDao entityDao;

    @Override
    public Author convert(String s) {
        Author author = entityDao.loadAuthorById(Long.parseLong(s));
        return author;
    }
}
