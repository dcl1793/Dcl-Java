package hs.dcl.test.util;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * @author dacl30868
 * @description: 参数校验测试
 * @date 2020/7/24 10:33
 */
public class ParamValidatUtil {


    public static void main(String[] args) {

        boolean integer = isInteger("1515");
        System.out.println(integer);

        boolean floa = isFloat("151.723");
        System.out.println(floa);
    }
    /**
     * 验证参数是否为正数,是true
     * @param object
     * @return
     */
    public final static boolean isInteger(Object object) {
        try {
            Pattern p = Pattern.compile("-?[0-9]+");
            Matcher m = p.matcher(object.toString());
            return m.matches();
        } catch (Exception e) {
            return false;
        }
    }

    /**
     * 验证参数是否为正浮点数,是true
     * @param object
     * @return
     */
    public final static boolean isFloat(Object object) {
        try {
            Pattern p = Pattern.compile("[1-9]\\d*.\\d*|0.\\d*[1-9]\\d*");
            Matcher m = p.matcher(object.toString());
            return m.matches();
        } catch (Exception e) {
            return false;
        }
    }
}
