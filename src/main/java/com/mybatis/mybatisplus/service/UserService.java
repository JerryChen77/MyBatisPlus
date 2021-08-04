package com.mybatis.mybatisplus.service;

import com.mybatis.mybatisplus.pojo.User;
import com.mybatis.mybatisplus.vo.ResultVO;

import java.util.List;

/**
 * @author Cjl
 * @date 2021/8/2 17:35
 */
public interface UserService {

    Integer save(User user);

    ResultVO login(String username, String password);
    List<User> loadUsers();
}
