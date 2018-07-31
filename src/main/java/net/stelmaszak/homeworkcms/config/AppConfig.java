package net.stelmaszak.homeworkcms.config;

import net.stelmaszak.homeworkcms.converter.AuthorConverter;
import net.stelmaszak.homeworkcms.converter.CategoryConverter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.format.FormatterRegistry;
import org.springframework.web.servlet.ViewResolver;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.view.InternalResourceViewResolver;

@Configuration
@EnableWebMvc
@ComponentScan("net.stelmaszak")
public class AppConfig {

    public void addFormatters(FormatterRegistry registry) {
        registry.addConverter(getAuthorConverter());
        registry.addConverter(getCategoryConverter());
    }

    @Bean
    public ViewResolver viewResolver() {
        InternalResourceViewResolver vr = new InternalResourceViewResolver();
        vr.setPrefix("/WEB-INF/jsp/");
        vr.setSuffix(".jsp");
        return vr;
    }

    @Bean
    public AuthorConverter getAuthorConverter() {
        return new AuthorConverter();
    }

    @Bean
    public CategoryConverter getCategoryConverter() {
        return new CategoryConverter();
    }

}
