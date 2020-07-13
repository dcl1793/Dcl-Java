package hs.dcl.test.util;

import java.util.ArrayList;
import java.util.List;

/**

 * @Description:    分隔工具

 * @Author:         weihb


 * @CreateDate:     2019/9/11 20:42

 * @Version:        1.0

 */
public class ListUtil {

    public static <T> List<List<T>> averageAssign(List<T> source, int n) {
        List<List<T>> result = new ArrayList<List<T>>();
        if (n <= 0 || source == null || source.size() == 0) {
            return result;
        }
        int remaider = source.size() % n;
        int number = source.size() / n;
        for (int i = 1; i <= number; i++) {
            List<T> value = new ArrayList<>();
            value = source.subList((i - 1) * n, i * n );
            result.add(value);
        }
        if(remaider >0){
            List<T> value = new ArrayList<>();
            value = source.subList(number * n, number * n + remaider);
            result.add(value);
        }
        return result;
    }
}
