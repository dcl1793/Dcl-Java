package hs.dcl.test.util;

import com.alibaba.fastjson.JSON;
import lombok.extern.slf4j.Slf4j;
import org.springframework.cglib.beans.BeanCopier;
import org.springframework.cglib.core.Converter;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**

 * @Description:    分隔工具

 * @Author:         weihb


 * @CreateDate:     2019/9/11 20:42

 * @Version:        1.0

 */
@Slf4j
public class ListUtil {

    /** 
    * @Description: 将集合均分
    * @Param:  
    * @return:  
    * @Author: dacl30868
    * @Date: 2020/7/13 
    */
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


    /**
     * 对象拷贝
     * @param source
     * @param target
     * @param <S>
     * @param <T>
     */
    public static <S, T> void copy(S source, T target) {
        copy(source, target, null);
    }

    public static <S, T> void copy(S source, T target, Converter converter) {
        if (source != null && target != null) {
            BeanCopier beanCopier = BeanCopier.create(source.getClass(), target.getClass(), converter != null);
            beanCopier.copy(source, target, converter);
        }
    }

    /**
     * 不同类型 列表拷贝
     */
    public static <T> List<T> copyList(List<?> source, Class<T> clazz) {
        if (source == null || source.size() == 0) {
            return Collections.emptyList();
        }
        List<T> res = new ArrayList<>(source.size());
        for (Object o : source) {
            try {
                T t = clazz.getDeclaredConstructor().newInstance();
                copy(o, t);
                res.add(t);
            } catch (Exception e) {
                log.error("copyList error", e);
            }
        }
        return res;
    }

    public static <T> List<T> copyJsonList(List<?> list,Class<T> clazz){
        String oldOb = JSON.toJSONString(list);
        return JSON.parseArray(oldOb, clazz);
    }
}
