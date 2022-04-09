package com.example.zjgsforum;

import com.example.zjgsforum.Bean.Forum;
import org.bson.types.ObjectId;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.StringRedisTemplate;

import javax.annotation.Resource;

@SpringBootTest
public class ForumTest {
//    @Resource
//    MongoTemplate mongoTemplate;
//
//    @Autowired
//    @Qualifier("redisTemplateCustomize")
//    RedisTemplate<String, Object> redisTemplate;
//
//    @Autowired
//    StringRedisTemplate stringRedisTemplate;
//
//    @Test
//    void say() {
//        System.out.println("hello");
//    }
//
//    @Test
//    void publish() {
////        ObjectId objectId = ObjectId.get();
//        Forum forum = new Forum(null, 1, "mytitle", "今日物语值.", 1);
//        mongoTemplate.insert(forum);
//        System.out.println(forum);
////        redisTemplate.opsForHash().put(objectId.toString(), "likes", 0);
////        redisTemplate.opsForHash().put(objectId.toString(), "visit", 0);
//    }
//
//    @Test
//    void Like() {
//        System.out.println(redisTemplate.opsForHash().increment("6244f61a311e670f3025d327", "likes", 1));
//    }
//
//    @Test
//    void UnLike() {
//        System.out.println(redisTemplate.opsForHash().increment("6244f61a311e670f3025d327", "likes", -1));
//
//    }
}
