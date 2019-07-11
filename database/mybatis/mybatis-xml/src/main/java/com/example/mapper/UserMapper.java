package com.example.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.example.entity.User;

@Mapper
public interface UserMapper {

    List<User> findAll();

    List<User> findByIds(List<Long> ids);

    User findById(long id);
}
