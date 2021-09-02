package hs.dcl.test.common;

public class RedisConstants {

    /**
     * app创建群组的key
     */
    public static final String CREATE_COMMAND = "1:";

    /**
     * 创建频道的key
     */
    public static final String CREATE_CHANNEL = "2:";

    /**
     * 创建群组的过期时间
     */
    public static final int CREATE_COMMAND_KEEP_TIME = 10 * 24 * 60 * 60;
}
