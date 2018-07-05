package com.example.demo.controller;

import com.example.demo.model.UserEntity;
import com.example.demo.service.impl.UserServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * Created by Mr.PanYang on 2018/3/15.
 *
 * @RestController 注解表示该类中的所有方法都会返回 json 格式数据，  =======》 @Controller  +   @ResponseBody
 * 是SpringMVC3.0 中的提供的注解
 */
@RestController
public class HomeController {

    @Autowired
    private UserServiceImpl userService;

    @RequestMapping("/getUsers")
    public List<UserEntity> getUsers() {
        return userService.getAllUsers();
    }

    @RequestMapping("/getUser")
    public UserEntity getUser(Long id) {
        return userService.getOne(id);
    }

    @RequestMapping("/add")
    public void save(UserEntity user) {
        userService.insert(user);
    }

    @RequestMapping(value = "update")
    public void update(UserEntity user) {
        userService.update(user);
    }

    @RequestMapping(value = "/delete/{id}")
    public void delete(@PathVariable("id") Long id) {
        userService.delete(id);
    }

}
