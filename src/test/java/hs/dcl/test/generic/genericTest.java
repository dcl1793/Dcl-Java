package hs.dcl.test.generic;

import cn.hutool.core.net.URLEncoder;
import cn.hutool.core.text.UnicodeUtil;
import com.google.common.base.Utf8;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.math.BigInteger;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.time.temporal.TemporalAdjuster;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@SpringBootTest
public class genericTest {

    @Test
    void Pair11() throws NoSuchAlgorithmException {

        //数据库：4c46f2e1706c97ad404393fa22560b3b

        //efd9d1b8bfb00e8e3647990f7d74d1d8

        //5ce2cc244d19d896f83f2474549c8bc6

        //82af58e718742e5922c0388fb35f36ba

        String str = "oldWangoldWang111111";

        //encryptPwd=EncryptUtils.encryptString("MD5", loginName+password);

        byte[] bytes = str.getBytes(StandardCharsets.UTF_8);

        // byte[] encodeBtyes = encrypt("MD5", bytes);

        MessageDigest md = MessageDigest.getInstance("MD5");
        byte[] encodeBtyes = md.digest(bytes);
        String hex = new BigInteger(1, encodeBtyes).toString(16);

        System.out.println(hex);

    }
}
