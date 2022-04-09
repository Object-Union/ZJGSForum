package com.example.zjgsforum.Controller;

import com.example.zjgsforum.Bean.User;
import com.example.zjgsforum.Bean.UserInfo;
import com.example.zjgsforum.Service.ServiceImpl.UserServiceImpl;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import javax.annotation.Resource;

@RestController
@RequestMapping("/User")
public class UserController {
    @Resource(name = "UserServiceImpl")
    UserServiceImpl userService;

    @RequestMapping("/Login")
    public Boolean Login(User user) {
        return userService.Login(user);
    }

    @RequestMapping("/Register")
    public Boolean Register(User user, String nickName, String avatarUrl) {
        return userService.Register(user, nickName, avatarUrl);
    }

    @RequestMapping("/GetUserInfo")
    public UserInfo GetUserInfo(Integer user_id) {
        return userService.GetUserInfo(user_id);
    }

    @RequestMapping("/UploadAvatar")
    public String editAvatar(MultipartFile avatar, Integer user_id) {
        return userService.UpLoadAvatar(avatar, user_id);
    }
}
