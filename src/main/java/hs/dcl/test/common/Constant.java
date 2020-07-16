package hs.dcl.test.common;

/**
 * 常量池
 * @author dacl30868
 * @date 2020/6/18 18:23
 */
public class Constant {

    public static final String SF_ERROR = "";
    /**
     * 正则表达式
     */
    public static final String REGEXP_MULTI_EMAIL_ADDRESS = "([a-zA-Z0-9_.-]+@[a-zA-Z0-9-]+(\\.[a-zA-Z0-9-]+)*\\.[a-zA-Z0-9]{2,6})(\\;[a-zA-Z0-9_.-]+@[a-zA-Z0-9-]+(\\.[a-zA-Z0-9-]+)*\\.[a-zA-Z0-9]{2,6})*";
    public static final String REGEXP_DEFAULT_DATE_TIME = "2[0-9]{3}-(0[1-9]|1[0-2])-([012][0-9]|3[01])\\s([01][0-9]|2[0-3])(\\:[0-5][0-9]){2}";
    public static final String REGEXP_NULLABLE_DATE_TIME = "2[0-9]{3}-(0[1-9]|1[0-2])-([012][0-9]|3[01])\\s([01][0-9]|2[0-3])(\\:[0-5][0-9]){2}|\\s*";



}
