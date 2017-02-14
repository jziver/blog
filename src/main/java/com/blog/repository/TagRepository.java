package com.blog.repository;

import com.blog.domain.Tag;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Created by Jiang on 2017/1/23.
 */
public interface TagRepository extends JpaRepository<Tag,Integer>{
}
