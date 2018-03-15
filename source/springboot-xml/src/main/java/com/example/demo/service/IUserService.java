package com.example.demo.service;

import com.example.demo.entity.UserEntity;

import java.util.List;

/**
 * Created by Mr.PanYang on 2018/3/15.
 */
public interface IUserService {

    List<UserEntity> getAllUsers();

    UserEntity getOne(int id);

    void insert(UserEntity user);

    void update(UserEntity user);

    void delete(int id);

}
