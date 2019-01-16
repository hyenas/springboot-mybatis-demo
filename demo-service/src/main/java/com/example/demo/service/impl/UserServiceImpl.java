package com.example.demo.service.impl;

import java.util.List;

import javax.annotation.Resource;

import com.example.demo.dao.UserMapper;
import com.example.demo.db.UserDO;
import com.example.demo.service.UserService;
import com.example.demo.vo.UserVO;
import org.springframework.stereotype.Service;

/**
 * Created by zhangyang on 19/1/16.
 *
 * @author zhangyang
 * @date 2019/01/16
 */
@Service(value = "userService")
public class UserServiceImpl implements UserService {
    @Resource
    private UserMapper userMapper;

    @Override
    public void addUser(UserDO user) {
        userMapper.addUser(user);
    }

    @Override
    public UserDO getUserById(Long userId) {
        return userMapper.getUserById(userId);
    }

    @Override
    public List<UserVO> listAllUsers() {
        return userMapper.listAllUsers();
    }
}
