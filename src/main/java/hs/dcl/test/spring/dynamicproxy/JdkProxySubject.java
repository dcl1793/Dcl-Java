package hs.dcl.test.spring.dynamicproxy;

import hs.dcl.test.spring.staticproxy.Subject;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

/**
 * @author dacl30868
 * @description: 自定义InvocationHandler的实现类
 * @date 2020/9/8 14:51
 */
public class JdkProxySubject implements InvocationHandler{

    //目标对象
    private Subject subject;

    public JdkProxySubject(Subject subject){
        this.subject = subject;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {

        System.out.println("before 前置通知");
        Object result = null;

        try {
            result = method.invoke(subject, args);
        }catch (Exception ex) {
            System.out.println("ex: " + ex.getMessage());
            throw ex;
        }finally {
            System.out.println("after 后置通知");
        }

        return null;
    }
}
