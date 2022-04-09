package com.example.zjgsforum.Utils;

import com.example.zjgsforum.Exception.NullElementException;
import com.example.zjgsforum.Exception.UploadException;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;

public class AvatarUploadUtil {
    private static final String UPLOAD_FOLDER = "/usr/share/avatar/";

    public static String uploadAvatar(MultipartFile avatar, Integer user_id) {
        if (avatar == null || user_id == null) {
            throw new NullElementException("上传内容为空");
        } else {
            String fileName = user_id + ".png";
            try {
                avatar.transferTo(new File(UPLOAD_FOLDER + fileName));
            } catch (IOException e) {
                throw new UploadException("上传文件失败");
            }

            return "http://xxx/avatar/" + fileName;
        }
    }
}
