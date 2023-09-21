package com.shi.dao;

import com.shi.po.User;
import com.shi.po.UserQuery;

import java.util.List;

public interface UserDao {
    User queryById(Integer id);

    User queryUserByUserName(String userName);

    int save(User user);

    int update(User user);

    List<User> selectByParams(UserQuery userQuery);

    int delete(Integer userid);
}
