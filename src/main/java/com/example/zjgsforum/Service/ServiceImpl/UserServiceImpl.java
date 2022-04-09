package com.example.zjgsforum.Service.ServiceImpl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.example.zjgsforum.Bean.User;
import com.example.zjgsforum.Bean.UserForum;
import com.example.zjgsforum.Bean.UserInfo;
import com.example.zjgsforum.Dao.UserMapper;
import com.example.zjgsforum.Exception.IllegalDataException;
import com.example.zjgsforum.Exception.NullElementException;
import com.example.zjgsforum.Exception.SameAccountException;
import com.example.zjgsforum.Service.UserService;
import com.example.zjgsforum.Utils.AvatarUploadUtil;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.core.query.Update;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import javax.annotation.Resource;
import java.util.ArrayList;

@Service("UserServiceImpl")
public class UserServiceImpl extends ServiceImpl<UserMapper, User> implements UserService {
    @Resource(name = "UserMapper")
    UserMapper userMapper;

    @Resource
    MongoTemplate mongoTemplate;

    @Override
    public Boolean Login(User user) {
        if (user == null) throw new NullElementException("登录用户为null");
        return userMapper.getUserId(user) != null;
    }

    @Override
    public Boolean Register(User user, String nickName, String avatarUrl) {
        if (user == null||nickName == null||nickName.equals("")) throw new NullElementException("注册用户为null");

        if (user.getAccount().length() > User.ACCOUNT_MAX_LENGTH ||
                user.getPassword().length() > User.PASSWORD_MAX_LENGTH ||
                nickName.length() > UserInfo.NICKNAME_MAX_LENGTH)
            throw new IllegalDataException("注册字段不合法");

        User selectUser = userMapper.selectOne(new QueryWrapper<User>().eq("account", user.getAccount()));
        if (selectUser != null) throw new SameAccountException("账号重复,请重新输入账号");
        // 将用户账号密码存入 mysql
        userMapper.insert(user);
        // 将新注册用户填入 user_info 表中
        mongoTemplate.insert(new UserInfo(null, user.getUser_id(), nickName, avatarUrl));
        // 将新用户填入 user_forum表中
        mongoTemplate.insert(new UserForum(null, user.getUser_id(), new ArrayList<>(), new ArrayList<>(), new ArrayList<>(), new ArrayList<>()));
        return true;
    }

    @Override
    public UserInfo GetUserInfo(Integer user_id) {
        if (user_id == null) throw new NullElementException("传入user_id为null!");
        // 在 user_info 表中查询用户信息
        return mongoTemplate.findOne(new Query(Criteria.where("user_id").is(user_id)), UserInfo.class);
    }

    @Override
    public String UpLoadAvatar(MultipartFile avatar, Integer user_id) {
        String newAvatar = AvatarUploadUtil.uploadAvatar(avatar, user_id);
        // 在 user_info 修改用户头像
        mongoTemplate.updateFirst(new Query(Criteria.where("user_id").is(user_id)), new Update().set("avatar", newAvatar), UserInfo.class);
        return newAvatar;
    }
}
