package com.example.zjgsforum.Controller;

import com.example.zjgsforum.Bean.Forum;
import com.example.zjgsforum.Service.ServiceImpl.ForumServiceImpl;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

@RestController
@RequestMapping("/Forum")
public class ForumController {
    @Resource(name = "ForumServiceImpl")
    ForumServiceImpl forumService;

    @RequestMapping("/Publish")
    public Boolean Publish(Forum forum) {
        return forumService.Publish(forum);
    }

    @RequestMapping("/Like")
    public Long Like(String _id, Integer user_id) {
        return forumService.Like(_id, user_id);
    }

    @RequestMapping("/UnLike")
    public Long UnLike(String _id, Integer user_id) {
        return forumService.UnLike(_id, user_id);
    }

    @RequestMapping("/GetForumById")
    public Forum GetForumById(String _id) {
        return forumService.GetForumById(_id);
    }

    @RequestMapping("GetForumLikeById")
    public Integer GetForumLikeById(String _id) {
        return forumService.GetForumLikeById(_id);
    }

    @RequestMapping("GetForumVisitById")
    public Integer GetForumVisitById(String _id) {
        return forumService.GetForumVisitById(_id);
    }

    @RequestMapping("VisitForum")
    public void VisitForum(String _id) {
        forumService.VisitForum(_id);
    }
}
