package com.bite.book.service;


import com.bite.book.mapper.UserInfoMapper;
import com.bite.book.model.UserInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {
    @Autowired
    private UserInfoMapper userInfoMapper;
    public UserInfo getUserInfoByname(String name){
        return userInfoMapper.selectUserByName(name);
    }
}
