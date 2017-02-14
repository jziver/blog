package com.blog.repository;

import com.blog.domain.Category;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

/**
 * Created by Jiang on 2017/1/23.
 */
public interface CategoryRepository extends JpaRepository<Category,Integer> {

}
