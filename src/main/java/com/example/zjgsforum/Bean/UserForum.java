package com.example.zjgsforum.Bean;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
import org.bson.types.ObjectId;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;
import org.springframework.stereotype.Component;

import java.util.List;

@Data
@ToString
@Component
@NoArgsConstructor
@AllArgsConstructor
@Document("user_forum")
public class UserForum {
    @Indexed
    private ObjectId _id;

    @Indexed
    @Field("user_id")
    private Integer user_id;

    @Field("publish_forum")
    private List<String> publish_forum;

    @Field("history_view")
    private List<String> history_view;

    @Field("collect_forum")
    private List<String> collect_forum;

    @Field("like_forum")
    private List<String> like_forum;
}
