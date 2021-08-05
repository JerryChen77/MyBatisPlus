package com.mybatis.mybatisplus.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.mybatis.mybatisplus.mapper.IUserMapper;
import com.mybatis.mybatisplus.pojo.User;
import com.mybatis.mybatisplus.service.UserService;
import com.mybatis.mybatisplus.vo.ResultVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * @author Cjl
 * @date 2021/8/2 17:35
 */
@Service
@Transactional
public class UserServiceImpl implements UserService {
    @Autowired
    IUserMapper userMapper;
    @Autowired
    ResultVO resultVO;

    @Override
    public Integer save(User user) {
        int insert = userMapper.insert(user);
        return insert;
    }

    @Override
    public ResultVO login(String username, String password) {
        QueryWrapper queryWrapper = new QueryWrapper();
        queryWrapper.eq("user_name",username);
        User byUsername = userMapper.selectOne(queryWrapper);
        if (byUsername==null){
            resultVO.setSuccess(false);
            resultVO.setMessage("用户不存在，请先注册");
            return resultVO;
        }else if (byUsername.getPassword().equals(password)){
            resultVO.setSuccess(true);
            resultVO.setMessage("用户名密码正确！！！");
            resultVO.setData(byUsername);
            return resultVO;
        }else{
            resultVO.setSuccess(false);
            resultVO.setMessage("用户名密码错误！！！");
            return resultVO;
        }
    }

    @Override
    public List<User> loadUsers() {
        List<User> users = userMapper.selectList(null);
        return users;
    }
}
