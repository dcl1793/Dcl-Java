package hs.dcl.test.util;


import java.util.List;

/**
 * @author dacl30868
 * @description: 字符拼接工具类
 * @date 2020/7/3 9:11
 */
public class SplitStringUtil {
    
    /**
     * String.join(CharSequence delimiter, CharSequence... elements)
     *
     * @param urls url
     *
     * @see String
     */
    @Deprecated
    public static String SplitUrl(List<String> urls) {
        StringBuffer resultBuffer = new StringBuffer();
        for (int i = 0; i < urls.size(); i++) {
            String result = urls.get(i);
            if (i == 0) {
                resultBuffer.append(result);
            } else {
                resultBuffer.append("|" + result);
            }
        }
        String.join(",","urls");
        return resultBuffer.toString();
    }
}
