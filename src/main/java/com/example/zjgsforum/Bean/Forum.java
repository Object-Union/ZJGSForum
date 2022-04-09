package com.example.zjgsforum.Bean;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
import org.bson.types.ObjectId;
import org.springframework.data.annotation.Transient;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;
import org.springframework.stereotype.Component;

@Data
@ToString
@Component
@NoArgsConstructor
@AllArgsConstructor
@Document("forums")
public class Forum {
    public static final Integer TITLE_MAX_LENGTH = 25;
    public static final Integer DETAIL_MAX_LENGTH = 512;

    @Indexed
    private ObjectId _id;

    @Indexed
    @Field("user_id")
    private Integer user_id;

    @Transient
    private Integer likes;

    @Transient
    private Integer visit;

    @Field("title")
    private String title;

    @Field("detail")
    private String detail;

    @Field("type_id")
    private Integer type_id;

    public Forum(ObjectId _id, Integer user_id, String title, String detail, Integer type_id) {
        this._id = _id;
        this.user_id = user_id;
        this.title = title;
        this.detail = detail;
        this.type_id = type_id;
    }
}
