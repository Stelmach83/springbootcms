package net.stelmaszak.homeworkcms.validator;

import net.stelmaszak.homeworkcms.entity.Category;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import java.util.List;

public class MaxCategoriesValidator implements ConstraintValidator<MaxCategories, List<Category>> {

    private String maxNumberOfCats;

    @Override
    public void initialize(MaxCategories constraintAnnotation) {
        this.maxNumberOfCats = constraintAnnotation.value();
    }

    @Override
    public boolean isValid(List<Category> categoryList, ConstraintValidatorContext constraintValidatorContext) {
        Integer maxCats = Integer.parseInt(maxNumberOfCats);
        if (categoryList.size() > maxCats) {
            return false;
        } else {
            return true;
        }
    }


}
