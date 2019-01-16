package com.example.demo.service;

import java.util.List;

import com.example.demo.db.UserDO;
import com.example.demo.vo.UserVO;

/**
 * Created by zhangyang on 19/1/16.
 *
 * @author zhangyang
 * @date 2019/01/16
 */
public interface UserService {
    /**
     * 添加用户信息
     */
    void addUser(UserDO User);
    /**
     * 根据ID获取用户信息
     *
     * 用户ID
     * @param userId
     */
    UserDO getUserById(Long userId);
    /**
     * 获取所有用户
     */
    List<UserVO>  listAllUsers();
}
