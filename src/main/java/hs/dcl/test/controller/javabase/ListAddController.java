package hs.dcl.test.controller.javabase;

import org.springframework.util.Base64Utils;

import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;
import java.util.List;

public class ListAddController {
    public static void main(String[] args) throws NoSuchAlgorithmException {

//  wgrU12/pd1mqJ6DJm/9nEA==
// H4R1FBK3rIzOq3tS39HjtA==
        MessageDigest md5 = null;
        // MD5加密
        md5 = MessageDigest.getInstance("MD5");

        // 密码进行加密操作
        String password = new String(Base64Utils.encode(md5.digest("12".getBytes(StandardCharsets.UTF_8))),
                StandardCharsets.UTF_8);

        System.out.println(password);
    }

}
