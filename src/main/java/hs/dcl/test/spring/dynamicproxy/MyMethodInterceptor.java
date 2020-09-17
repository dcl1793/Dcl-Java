package hs.dcl.test.spring.dynamicproxy;


import org.springframework.cglib.proxy.MethodInterceptor;
import org.springframework.cglib.proxy.MethodProxy;

import java.lang.reflect.Method;

/**
 * @author dacl30868
 * @description: 自定义MethodInterceptor实现类
 * @date 2020/9/8 15:17
 */
public class MyMethodInterceptor implements MethodInterceptor {


    @Override
    public Object intercept(Object o, Method method, Object[] objects, MethodProxy methodProxy) throws Throwable {

        System.out.println("before 前置通知");
        Object result = null;
        try {
            result = methodProxy.invokeSuper(o, objects);
        }catch (Exception ex) {
            System.out.println("ex: " + ex.getMessage());
            throw ex;
        }finally {
            System.out.println("after 后置通知");
        }
        return result;
    }
}
