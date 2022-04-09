package com.example.zjgsforum.Service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.example.zjgsforum.Bean.User;
import com.example.zjgsforum.Bean.UserInfo;
import org.springframework.web.multipart.MultipartFile;

public interface UserService extends IService<User> {
    //登录返回是否成功
    Boolean Login(User user);

    //注册返回是否成功
    Boolean Register(User user,String nickName,String avatarUrl);

    //获取User的相关信息
    UserInfo GetUserInfo(Integer user_id);

    //上传User头像
    String UpLoadAvatar(MultipartFile avatar, Integer user_id);
}
