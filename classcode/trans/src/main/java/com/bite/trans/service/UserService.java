package com.bite.trans.service;

import com.bite.trans.mapper.UserInfoMapper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Slf4j
@Service
public class UserService {
    @Autowired
    private UserInfoMapper userInfoMapper;
    public Integer registryUser(String userName,String password){
//插入用户信息
       return userInfoMapper.insert(userName,password);
    }
}