package com.springboot_test01.demo.service.impl;


import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.springboot_test01.demo.dao.UserDao;
import com.springboot_test01.demo.pojo.User;
import com.springboot_test01.demo.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @Auther: szp
 * @Date: 2020/1/4 21:40
 * @Description:
 */
@Slf4j
@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserDao userDao;
    @Override
    public Integer addUser(User user) {
        return userDao.addUser(user);
    }

    @Override
    public List<User> findAllUser(Integer pageSize,Integer pageNumber) {
        //开始分页，必须写在上面
        PageHelper.startPage(pageNumber,pageSize);
        List<User> all = userDao.findAllUser();
        PageInfo<User> pageInfo=new PageInfo<>(all);
        log.info("all-{}",all);
        log.info("pageInfo.getList()-{}",pageInfo.getList());
        log.info("pagesize-{},pageNumber-{}",pageSize,pageNumber);
        return pageInfo.getList();
    }

    @Override
    public Integer updateUser(User user) {
        return userDao.updateUser(user);
    }
}
