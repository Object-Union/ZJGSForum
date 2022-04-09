package com.example.zjgsforum.Bean;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
import org.springframework.stereotype.Component;

@Data
@ToString
@Component
@NoArgsConstructor
@AllArgsConstructor
@TableName("zjgsforum.user")
public class User {
    public static final Integer ACCOUNT_MAX_LENGTH = 11;
    public static final Integer PASSWORD_MAX_LENGTH = 11;

    @TableId(value = "user_id", type = IdType.AUTO)
    private Integer user_id;

    @TableField("account")
    private String account;

    @TableField("password")
    private String password;

    public User(String account, String password) {
        this.account = account;
        this.password = password;
    }
}
