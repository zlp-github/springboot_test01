package com.springboot_test01.demo.controller;


import com.springboot_test01.demo.common.SzpJsonResult;
import com.springboot_test01.demo.pojo.User;
import com.springboot_test01.demo.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @Auther: szp
 * @Date: 2020/1/4 21:40
 * @Description:
 */
@Slf4j
@RestController
public class UserController {
    @Autowired
    private UserService userService;
    @GetMapping("find/all/user")
    public SzpJsonResult<User> findAllUser(Integer pageSize,Integer pageNumber){
        log.info("开始查找用户-----------"+pageSize);
        return SzpJsonResult.ok(userService.findAllUser(pageSize,pageNumber));
    }

    /**
     * 通过form表单提交
     * @param user
     * @return
     */
    @PostMapping
    public Integer addUser(User user){
        return userService.addUser(user);
    }

    /**
     * 通过json提交
     * @param user
     * @return
     */
    @PostMapping("add/user/by/json")
    public SzpJsonResult<Integer> addUserByJson(@RequestBody User user){
        Integer result = userService.addUser(user);
        return SzpJsonResult.ok(result);
    }

    @PostMapping("update/user")
    public Integer updateUser(@RequestBody User user){
        return userService.updateUser(user);
    }
}
