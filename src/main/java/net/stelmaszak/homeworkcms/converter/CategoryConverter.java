package net.stelmaszak.homeworkcms.converter;

import net.stelmaszak.homeworkcms.entity.Category;
import net.stelmaszak.homeworkcms.repository.CategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.converter.Converter;

public class CategoryConverter implements Converter<String, Category> {

    @Autowired
    CategoryRepository categoryRepository;

    @Override
    public Category convert(String s) {
        Category category = categoryRepository.getOne(Long.parseLong(s));
        return category;
    }
}
