package com.shi.controller;

import com.github.pagehelper.PageInfo;
import com.shi.exception.ParmsException;
import com.shi.po.ResultInfo;
import com.shi.po.User;
import com.shi.po.UserQuery;
import com.shi.service.UserService;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiOperation;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.validation.Valid;

@Controller
public class Usercontroller {
    @Resource
    private UserService userService;

    //    @GetMapping("user/{userid}")
//    @ResponseBody
//    public User getUser(@PathVariable Integer userid){
//        System.out.println("userid:");
//        User user = userService.queryuserByuserId(userid);
//        return user;
//    }
//
//
    @GetMapping(value = "user/uname/{userName}",produces = "application/json;charset=utf-8")
    @ApiOperation(value = "根据用户名查询用户记录")
    @ApiImplicitParam(name = "userName", value = "查询参数", required = true, paramType = "path")
    @ResponseBody
    @Cacheable(value = "users",key = "#userName")
    public User queryUserByUserName(@PathVariable String userName) {
        return userService.queryUserByUserName(userName);
    }

    @GetMapping(value = "user/list",produces = "application/json;charset=utf-8")
    @ResponseBody
    @ApiOperation(value = "多条件查询用户列表记录")
    @Cacheable(value = "users",key="#userQuery.username+'-'+#userQuery.pageNum+'-'+#userQuery.pageSize")
    public PageInfo<User> list(UserQuery userQuery) {
        return userService.queryUserByParams(userQuery);
    }

    //
    @GetMapping(value = "user/{userId}",produces = "application/json;charset=utf-8")
    @ResponseBody
    @ApiOperation(value = "根据用户id查询用户记录")
    @ApiImplicitParam(name = "userId",value = "查询参数",required = true,paramType = "path")
    @Cacheable(value = "users",key = "#userId")
    public User queryUserByUserId(@PathVariable Integer userId) {
        return userService.queryuserByuserId(userId);
    }


    @PutMapping(value = "user",produces = "application/json;charset=utf-8")
    @ResponseBody
    @ApiOperation(value = "用户添加")
    @ApiImplicitParam(name = "user",value = "用户实体类",dataType = "User")
    public ResultInfo saveUser(@Valid User user) {
        ResultInfo resultInfo = new ResultInfo();
        try {
            userService.saveuser(user);
        } catch (ParmsException e) {
            e.printStackTrace();
            resultInfo.setCode(e.getCode());
            resultInfo.setMsg(e.getMsg());
        } catch (Exception e) {
            e.printStackTrace();
            resultInfo.setCode(300);
            resultInfo.setMsg("记录添加失败!");
        }
        return resultInfo;
    }

    @PostMapping(value = "user",produces = "application/json;charset=utf-8")
    @ResponseBody
    @ApiOperation(value = "用户更新")
    @ApiImplicitParam(name = "user",value = "用户实体类",dataType = "User")
    @CacheEvict(value = "users",key="#user.userid")
    public ResultInfo updateUser(@Valid User user) {
        ResultInfo resultInfo = new ResultInfo();
        try {
            userService.updateuser(user);
        } catch (ParmsException e) {
            e.printStackTrace();
            resultInfo.setCode(e.getCode());
            resultInfo.setMsg(e.getMsg());
        } catch (Exception e) {
            e.printStackTrace();
            resultInfo.setCode(300);
            resultInfo.setMsg("记录更新失败!");
        }
        return resultInfo;
    }

    @DeleteMapping(value = "user/{userId}",produces = "application/json;charset=utf-8")
    @ResponseBody
    @ApiOperation(value = "根据用户id删除用户记录")
    @ApiImplicitParam(name = "userId",value = "查询参数",required = true,paramType = "path")
    @CacheEvict(value = "users",allEntries = true)
    public ResultInfo deleteUser(@PathVariable Integer userId) {
        ResultInfo resultInfo = new ResultInfo();
        try {
            userService.deleteuser(userId);

        } catch (ParmsException e) {
            e.printStackTrace();
            resultInfo.setCode(e.getCode());
            resultInfo.setMsg(e.getMsg());
        } catch (Exception e) {
            e.printStackTrace();
            resultInfo.setCode(300);
            resultInfo.setMsg("记录删除失败!");
        }
        return resultInfo;
    }
}
