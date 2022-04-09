package com.example.zjgsforum;

import com.example.zjgsforum.Bean.User;
import com.example.zjgsforum.Dao.UserMapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.redis.core.RedisTemplate;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;

@SpringBootTest
public class DBTest {
//    @Resource(name = "UserMapper")
//    UserMapper userMapper;
//
//    @Autowired
//    MongoTemplate mongoTemplate;
//
//    @Autowired
//    @Qualifier("redisTemplateCustomize")
//    RedisTemplate<String, Object> redisTemplate;
//
//    //验证登录
//    @Test
//    void TestMysql() {
//        Integer root = userMapper.getUserId(new User("root", "123456"));
//        System.out.println(root);
//    }
//
//    //验证插入返回用户ID
//    @Test
//    void insertToMysql() {
//        User user = new User("robot2", "123456", "irobot");
//        userMapper.insert(user);
//        System.out.println(user);
//    }
//
//    //根据用户id返回用户数据
//    @Test
//    void TestMongoDB() {
//        User byId = mongoTemplate.findOne(new Query(Criteria.where("user_id").is(6)),User.class);
//        System.out.println(byId);
//    }
//
//    @Test
//    void searchByMysqlAndMongoDB() {
//        Integer root = userMapper.getUserId(new User("root", "123456"));
//        System.out.println(root);
//        User login = mongoTemplate.findById(root, User.class);
//        System.out.println(login);
//    }
//
//    @Test
//    void TestRedis() {
//        Object test = redisTemplate.opsForValue().get("test");
//        System.out.println(test);
//    }
//
//    //注册时，向mysql和mongodb插入用户信息
//    @Test
//    void insertUserIntoMysqlAndMongoDB() {
//        User user = new User("robot6", "123456", "irobot");
//        userMapper.insert(user);
//        System.out.println(user);
//        user.setPublish_forum(new ArrayList<>());
//        User mongo = mongoTemplate.insert(user);
//        System.out.println(mongo);
//    }

}
