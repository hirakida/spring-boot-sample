package com.example.repository;

import java.util.List;
import java.util.stream.Stream;

import org.springframework.data.jdbc.repository.query.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import com.example.entity.User;

public interface UserRepository extends CrudRepository<User, Integer> {

    @Query("SELECT * FROM user WHERE id = :id")
    User findOne(@Param("id") Integer id);

    @Query("SELECT * FROM user ORDER BY id")
    Stream<User> findAllStream();

    @Query("SELECT * FROM user ORDER BY id")
    List<User> findAllList();
}
