package com.pps.mapper;

import com.pps.entity.User;

public interface UserMapper {

    User findUserById(Integer id);

    int  insert(User user);

}
