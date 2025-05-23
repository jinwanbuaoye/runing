package com.bite.book.mapper;

import com.bite.book.model.UserInfo;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

@Mapper
public interface UserInfoMapper {
    /**
     * 根据用户名称查询用户信息
     * @return
     */
    @Select("select  * from user_info where user_name = #{name}")
    UserInfo selectUserByName(String name);
}
