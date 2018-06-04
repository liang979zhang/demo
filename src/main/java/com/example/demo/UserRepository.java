package com.example.demo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

import java.util.List;

/**
 * 可以自定义一些查询语句
 */
public interface UserRepository extends JpaRepository<User, Long> ,JpaSpecificationExecutor<User> {

    User findByName(String name);

    List<User> findByNameLike(String name);


    List<User>  findByAge(int age);



}
