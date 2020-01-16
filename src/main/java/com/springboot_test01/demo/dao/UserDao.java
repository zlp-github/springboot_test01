package com.springboot_test01.demo.dao;


import com.springboot_test01.demo.mapper.UserMapper;
import com.springboot_test01.demo.pojo.User;
import com.springboot_test01.demo.pojo.UserExample;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @Auther: szp
 * @Date: 2020/1/4 21:31
 * @Description: 用户dao
 */
@Repository
public class UserDao {
    @Autowired
    private UserMapper userMapper;

    public List<User> findAllUser(){
        UserExample userExample=new UserExample();
        return userMapper.selectByExample(userExample);
    }

    public Integer addUser(User user){
        return userMapper.insert(user);
    }

    public Integer updateUser(User user){
        return userMapper.updateByPrimaryKeySelective(user);
    }
}
