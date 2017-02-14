package com.blog.repository;

import com.blog.domain.User;
import org.springframework.data.jpa.repository.JpaRepository;


public interface UserRepository extends JpaRepository<User,Integer>{

    User findUserByUsername(String account);

}
