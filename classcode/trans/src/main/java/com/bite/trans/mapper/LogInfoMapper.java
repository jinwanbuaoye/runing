package com.bite.trans.mapper;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

@Mapper
public interface LogInfoMapper {
    @Insert("insert into log_info(`user_name`,`op`)values(#{userName},#{op})")
    Integer insertLog(@Param("userName")String userName, @Param("op")String op);
}
