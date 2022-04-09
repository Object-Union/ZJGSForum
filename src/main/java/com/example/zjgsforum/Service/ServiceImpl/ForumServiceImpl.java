package com.example.zjgsforum.Service.ServiceImpl;

import com.example.zjgsforum.Bean.Forum;
import com.example.zjgsforum.Bean.UserForum;
import com.example.zjgsforum.Exception.IllegalDataException;
import com.example.zjgsforum.Exception.NullElementException;
import com.example.zjgsforum.Service.ForumService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.core.query.Update;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service("ForumServiceImpl")
public class ForumServiceImpl implements ForumService {
    @Resource
    MongoTemplate mongoTemplate;

    @Autowired
    @Qualifier("redisTemplateCustomize")
    RedisTemplate<String, Object> redisTemplate;

    @Override
    public Boolean Publish(Forum forum) {
        if (forum == null) throw new NullElementException("发表帖子为null!");
        if (forum.getTitle().length() > Forum.TITLE_MAX_LENGTH ||
                forum.getDetail().length() > Forum.DETAIL_MAX_LENGTH)
            throw new IllegalDataException("字数过多!");

        String objectID = mongoTemplate.insert(forum).get_id().toString();
        redisTemplate.opsForHash().put(objectID, "likes", 0);
        redisTemplate.opsForHash().put(objectID, "visit", 0);
        mongoTemplate.updateFirst(new Query(Criteria.where("user_id").is(forum.getUser_id())),
                new Update().push("publish_forum", objectID), UserForum.class);
        return forum.get_id() != null;
    }

    @Override
    public Long Like(String _id, Integer user_id) {
        if (_id == null || user_id == null) throw new NullElementException("传入帖子id或用户id为null");
        mongoTemplate.updateFirst(new Query(Criteria.where("user_id").is(user_id)),
                new Update().addToSet("like_forum", _id), UserForum.class);
        return redisTemplate.opsForHash().increment(_id, "likes", 1);
    }

    @Override
    public Long UnLike(String _id, Integer user_id) {
        if (_id == null || user_id == null) throw new NullElementException("传入帖子id或用户id为null");
        mongoTemplate.updateFirst(new Query(Criteria.where("user_id").is(user_id)),
                new Update().pull("like_forum", _id), UserForum.class);
        return redisTemplate.opsForHash().increment(_id, "likes", -1);
    }

    @Override
    public Forum GetForumById(String _id) {
        if (_id == null) throw new NullElementException("传入的_id为null!");
        return mongoTemplate.findById(_id, Forum.class);
    }

    @Override
    public Integer GetForumLikeById(String _id) {
        if (_id == null) throw new NullElementException("传入的_id为null!");
        return (Integer) redisTemplate.opsForHash().get(_id, "likes");
    }

    @Override
    public Integer GetForumVisitById(String _id) {
        if (_id == null) throw new NullElementException("传入的_id为null!");
        return (Integer) redisTemplate.opsForHash().get(_id, "visit");
    }

    @Override
    public void VisitForum(String _id) {
        if (_id == null) throw new NullElementException("传入的_id为null!");
        redisTemplate.opsForHash().increment(_id, "visit", 1);
    }
}
