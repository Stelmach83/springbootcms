package net.stelmaszak.homeworkcms.converter;

import net.stelmaszak.homeworkcms.dao.EntityDao;
import net.stelmaszak.homeworkcms.entity.Category;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.converter.Converter;

public class CategoryConverter implements Converter<String, Category> {

    @Autowired
    private EntityDao entityDao;

    @Override
    public Category convert(String s) {
        Category category = entityDao.loadCategoryById(Long.parseLong(s));
        return category;
    }
}
