package com.example.zjgsforum.Dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.example.zjgsforum.Bean.User;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

@Mapper
@Repository(value = "UserMapper")
public interface UserMapper extends BaseMapper<User> {
    Integer getUserId(User user);
}
