package com.example.demo.mapper;

import com.example.demo.entity.UserEntity;
import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * Created by Mr.PanYang on 2018/3/15.
 */
@Component
public interface UserMapper {

    List<UserEntity> getAll();

    UserEntity getOne(int id);

    void insert(UserEntity user);

    void update(UserEntity user);

    void delete(int id);
}
