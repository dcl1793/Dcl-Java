package hs.dcl.test.controller;

import cn.hutool.json.JSONObject;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.crypto.Cipher;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;

/**
 * AES128加解密工具类
 *
 * @author baojiong20176
 */
public class EncryptAlgorithmUtils {

    protected static final Logger logger = LoggerFactory.getLogger(EncryptAlgorithmUtils.class);

    /**
     * AES 加密
     *
     * @param text
     * @param secretKey
     * @param iv
     * @return
     * @throws Exception
     */
    public static String encrypt(String text, String secretKey, String iv) throws Exception {
        if (StringUtils.isBlank(text)) {
            return null;
        }
        try {
            IvParameterSpec ips = new IvParameterSpec(iv.getBytes());
            SecretKeySpec sks = new SecretKeySpec(secretKey.getBytes(), "AES");
            Cipher cipher = Cipher.getInstance("AES/CBC/PKCS5Padding");
            cipher.init(Cipher.ENCRYPT_MODE, sks, ips);
            byte[] encrypted = cipher.doFinal(padString(text).getBytes("UTF8"));
            return HsBase64EncodeUtils.encode(encrypted);
        } catch (Exception e) {
            logger.error(String.format("AES 加密%s错误。", text), e);
            return null;
        }
    }

    /**
     * 解密
     *
     * @param code
     * @param secretKey
     * @param iv
     * @return
     * @throws Exception
     */
    public static String decrypt(String code, String secretKey, String iv) {
        if (StringUtils.isBlank(code)) {
            return null;
        }
        try {
            IvParameterSpec ivspec = new IvParameterSpec(iv.getBytes());
            SecretKeySpec keyspec = new SecretKeySpec(secretKey.getBytes(), "AES");
            Cipher cipher = Cipher.getInstance("AES/CBC/PKCS5Padding");
            cipher.init(Cipher.DECRYPT_MODE, keyspec, ivspec);
            byte[] decrypted = cipher.doFinal(HsBase64EncodeUtils.decode(code));
            String result = new String(decrypted, "UTF8");
            return StringUtils.isBlank(result) ? StringUtils.EMPTY : result.trim();
        } catch (Exception e) {
            logger.error(String.format("AES 解密%s错误。", code), e);
            return null;
        }
    }


    /**
     * 补位
     *
     * @param source
     * @return
     */
    private static String padString(String source) {
        char paddingChar = 0x00;
        int size = 16;
        int x = source.length() % size;
        int padLength = size - x;

        for (int i = 0; i < padLength; i++) {
            source += paddingChar;
        }

        return source;
    }

    // RmlDw42x11xe3FtVovk4VQ==
    public static void main(String[] args) {
        try {
            String result = EncryptAlgorithmUtils.encrypt("{\"UserParam1\":\"j6CmSOsUngQsNZtzyfZ4gQxyKAxz8xhCe3p5\",\"session_no\":\"1002014597\",\"last_op_station\":\"IIP\\u003d255.255.255.255;IPORT\\u003dNA;LIP\\u003d255.255.255.255;MAC\\u003dNA;IDFV\\u003dNA;RMPN\\u003d15829258729;UMPN\\u003dNA;ICCID\\u003dNA;OSV\\u003dNA;IMSI\\u003dNA@TZYJ-13.1.101.133\",\"UserCode\":\"2\",\"fund_account\":\"91001049\",\"client_id\":\"91001049\",\"branch_no\":\"1112\",\"password\":\"369852\",\"user_token\":\"j6CmSOsUngQsNZtzyfZ4gQxyKAxz8xhCe3p5\",\"client_name\":\"@测@20200116044608437964000000\"}", "k.www.10jqka.com", "offset.10jqkacom");
            System.out.println(result);

            String decrypt = EncryptAlgorithmUtils.decrypt(result, "k.www.10jqka.com", "offset.10jqkacom");

            System.out.println();
            JSONObject jsonObj = new JSONObject(decrypt);
            String op_branch_no = jsonObj.getStr("op_branch_no");
            System.out.println(op_branch_no);

        } catch (Exception e) {
            e.printStackTrace();
        }

    }
}