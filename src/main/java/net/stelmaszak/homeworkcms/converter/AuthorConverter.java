package net.stelmaszak.homeworkcms.converter;

import net.stelmaszak.homeworkcms.entity.Author;
import net.stelmaszak.homeworkcms.repository.AuthorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.converter.Converter;

public class AuthorConverter implements Converter<String, Author> {

    @Autowired
    AuthorRepository authorRepository;

    @Override
    public Author convert(String s) {
        Author author = authorRepository.getOne(Long.parseLong(s));
        return author;
    }
}
