package com.springboot_test01.demo.service;



import com.springboot_test01.demo.pojo.User;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @Auther: szp
 * @Date: 2020/1/4 21:40
 * @Description:
 */
@Service
public interface UserService {
    Integer addUser(User user);
    List<User> findAllUser(Integer pageSize,Integer pageNumber);
    Integer updateUser(User user);
}
