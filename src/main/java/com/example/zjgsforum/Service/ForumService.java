package com.example.zjgsforum.Service;


import com.example.zjgsforum.Bean.Forum;

public interface ForumService {
    //发布一篇帖子
    Boolean Publish(Forum forum);

    //点赞一篇帖子
    Long Like(String _id, Integer user_id);

    //取消点赞
    Long UnLike(String _id, Integer user_id);

    //根据_id搜索帖子
    Forum GetForumById(String _id);

    //获取点赞数
    Integer GetForumLikeById(String _id);

    //获取浏览量
    Integer GetForumVisitById(String _id);

    //增加访问量
    void VisitForum(String _id);
}
