package com.blog.repository;

import com.blog.domain.Article;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;


public interface ArticleRepository extends JpaRepository<Article,Integer>{


    List<Article> findByCategoryIdOrderByCreateTimeDesc(Integer categoryId);

    List<Article> findByTagsIdOrderByCreateTimeDesc(Integer id);
}
