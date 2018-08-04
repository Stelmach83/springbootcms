package net.stelmaszak.homeworkcms.repository;

import net.stelmaszak.homeworkcms.entity.Category;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CategoryRepository extends JpaRepository<Category, Long> {

    Category findByName(String name);
}
