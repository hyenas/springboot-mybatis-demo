package com.example.demo.controller;

import java.util.List;

import javax.annotation.Resource;

import com.example.demo.common.ErrorCodeEnum;
import com.example.demo.common.ResponseModel;
import com.example.demo.db.UserDO;
import com.example.demo.service.UserService;
import com.example.demo.vo.UserVO;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * Created by Administrator on 2017/8/16.
 */
@Controller

@RequestMapping("/api/user/")
public class UserController {
    @Resource
    private UserService userService;
    @RequestMapping(value = "listUsers", method = RequestMethod.GET)
    public @ResponseBody ResponseModel listUsers(){
        ResponseModel<List<UserVO>> responseModel = new ResponseModel<List<UserVO>>();
        try {
            List<UserVO> userList =  userService.listAllUsers();
            responseModel.setContent(userList);
        }
        catch (Exception e){
            responseModel.setError(ErrorCodeEnum.SYSTEM_ERROR);
        }

        return responseModel;
    }

    @RequestMapping(value = "getUserById", method = RequestMethod.GET)
    public @ResponseBody ResponseModel getUserById(
        @RequestParam(required = false) Long id){

        ResponseModel<UserDO> responseModel = new ResponseModel<UserDO>();
        try {
            UserDO userInfo =  userService.getUserById(id);
            responseModel.setContent(userInfo);
        }
        catch (Exception e){
            responseModel.setError(ErrorCodeEnum.SYSTEM_ERROR);
        }

        return responseModel;
    }



    @RequestMapping(value = "adduser", method = RequestMethod.POST)
    public @ResponseBody ResponseModel addUser(
            @RequestParam(required = false) String name,
            @RequestParam(required = false) String sex,
            @RequestParam(required = false) String age,
            @RequestParam(required = false) String company){

        ResponseModel<UserDO> responseModel = new ResponseModel<UserDO>();
        if(StringUtils.isAnyEmpty(name,sex)){
            responseModel.setError(ErrorCodeEnum.ILLEGAL_ARGUMENT);
            return responseModel;
        }
        try {
            UserDO userInfo = new UserDO();
            userInfo.setUserName(name);
            userInfo.setSex(sex);
            userInfo.setUserAge(age);
            userInfo.setCompany(company);

            userService.addUser(userInfo);

            responseModel.setContent(userInfo);
        }
        catch (Exception e){
            responseModel.setError(ErrorCodeEnum.SYSTEM_ERROR);
        }

        return responseModel;
    }
}
