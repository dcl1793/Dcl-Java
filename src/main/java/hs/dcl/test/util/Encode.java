package hs.dcl.test.util;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

/**
 * @author dcl
 * @version 1.0
 * @date 2022/7/7 14:32
 */
public class Encode {

    public static void main(String[] args) {
        String encode = new BCryptPasswordEncoder().encode("nacos123");
        System.out.println(encode);
    }
}
