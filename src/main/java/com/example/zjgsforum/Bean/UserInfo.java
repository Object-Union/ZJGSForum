package com.example.zjgsforum.Bean;

import com.baomidou.mybatisplus.annotation.TableField;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
import org.bson.types.ObjectId;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;
import org.springframework.stereotype.Component;

@Data
@ToString
@Component
@NoArgsConstructor
@AllArgsConstructor
@Document("user_info")
public class UserInfo {
    public static final Integer NICKNAME_MAX_LENGTH = 8;

    @Indexed
    private ObjectId _id;

    @Indexed
    @Field("user_id")
    private Integer user_id;

    @TableField("nick_name")
    private String nick_name;

    @Field("avatar")
    private String avatar;
}
