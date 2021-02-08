package hs.dcl.test.controller.lambda;

import java.math.BigInteger;
import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

/**
 * @author dacl30868
 * @description:
 * @date 2020/11/10 19:15
 */
public class ewrrwe {

    public static void main(String[] args) throws NoSuchAlgorithmException {

        //数据库：4c46f2e1706c97ad404393fa22560b3b
        String str = "admin111111";
        //encryptPwd=EncryptUtils.encryptString("MD5", loginName+password);
        byte[] bytes = str.getBytes(StandardCharsets.UTF_16LE);
        MessageDigest md = MessageDigest.getInstance("MD5");
        byte[] encodeBtyes = md.digest(bytes);
        String hex = new BigInteger(1, encodeBtyes).toString(16);
        System.out.println(hex);
    }
}
