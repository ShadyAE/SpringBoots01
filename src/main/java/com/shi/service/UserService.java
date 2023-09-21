package com.shi.service;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.shi.dao.UserDao;
import com.shi.po.User;
import com.shi.po.UserQuery;
import com.shi.utils.Assertutil;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;

@Service
public class UserService {
    @Resource
    private UserDao userDao;


    @Transactional(propagation = Propagation.REQUIRED)
    public PageInfo<User> queryUserByParams(UserQuery userQuery) {
        PageHelper.startPage(userQuery.getPageNum(), userQuery.getPageSize());
        return new PageInfo<User>(userDao.selectByParams(userQuery));
    }

    @Transactional(propagation = Propagation.REQUIRED)
    public User queryUserByUserName(String userName) {
        return userDao.queryUserByUserName(userName);
    }

    @Transactional(propagation = Propagation.REQUIRED)
    public User queryuserByuserId(Integer userId) {
        return userDao.queryById(userId);
    }

    @Transactional(propagation = Propagation.REQUIRED)
    public void saveuser(User user) {
        Assertutil.isTrue(StringUtils.isBlank(user.getUsername()), "用户名不能为空！");
        Assertutil.isTrue(StringUtils.isBlank(user.getPassword()), "用户密码不能为空！");
        User temp = userDao.queryUserByUserName(user.getUsername());
        Assertutil.isTrue(null != temp, "该用户已存在！");
        Assertutil.isTrue(userDao.save(user) < 1, "用户记录添加失败！");
    }

    @Transactional(propagation = Propagation.REQUIRED)
    public void updateuser(User user) {
        Assertutil.isTrue(StringUtils.isBlank(user.getUsername()), "用户名不能为空！");
        Assertutil.isTrue(StringUtils.isBlank(user.getPassword()), "用户密码不能为空！");
        User temp = userDao.queryUserByUserName(user.getUsername());
        Assertutil.isTrue(null != temp & (temp.getUserid() == (user.getUserid())), "用户己存在！");
        Assertutil.isTrue(userDao.update(user) < 1, "用户记录添加失败！");
    }

    @Transactional(propagation = Propagation.REQUIRED)
    public void deleteuser(Integer id) {
        Assertutil.isTrue(null == id || null == userDao.queryById(id), "待删除记录不存在！");
        Assertutil.isTrue(userDao.delete(id) < 1, "用户删除失败！");
    }
}
