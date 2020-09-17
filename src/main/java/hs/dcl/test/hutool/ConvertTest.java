package hs.dcl.test.hutool;

import cn.hutool.core.convert.Convert;
import cn.hutool.core.date.DateUtil;
import cn.hutool.core.util.StrUtil;
import org.junit.Test;

import java.util.Date;
import java.util.List;
import java.util.concurrent.TimeUnit;

/**
 * @author dacl30868
 * @description: 类型转换测试
 * @date 2020/9/7 16:24
 */
public class ConvertTest {

    @Test
    public static void StringTo() {

        int a = 1;
        String aStr = Convert.toStr(a);

        long[] b = {1,2,3,4,5};
        String bStr = Convert.toStr(b);

        String[] b1 = { "1", "2", "3", "4" };
        Integer[] intArray = Convert.toIntArray(b1);

        long[] c = {1,2,3,4,5};
        Integer[] intArray2 = Convert.toIntArray(c);

        String a1 = "2017-05-06";
        Date value = Convert.toDate(a1);

        Object[] a2 = {"a", "你", "好", "", 1};
        List<?> list = Convert.toList(a2);

        long aa = 4535345;
        long minutes = Convert.convertTime(aa, TimeUnit.MILLISECONDS, TimeUnit.MINUTES);

        String dateStr = "2017-03-01";
        Date date = DateUtil.parse(dateStr);

        //截取字符串
        String strSub1 = StrUtil.sub(bStr, 2, 3);

        //结果 2017/03/01
        String format = DateUtil.format(date, "yyyy/MM/dd");

        //常用格式的格式化，结果：2017-03-01
        String formatDate = DateUtil.formatDate(date);

        //结果：2017-03-01 00:00:00
        String formatDateTime = DateUtil.formatDateTime(date);

        //结果：00:00:00
        String formatTime = DateUtil.formatTime(date);

    }
}
