package hs.dcl.test.spring.dynamicproxy;

import hs.dcl.test.spring.staticproxy.RealSubject;
import hs.dcl.test.spring.staticproxy.Subject;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Proxy;

/**
 * @author dacl30868
 * @description:
 * @date 2020/9/8 14:57
 */
public class Main {

    public static void main(String[] args) {

        //获取InvocationHandler对象 在构造方法中注入目标对象
        InvocationHandler handler = new JdkProxySubject(new RealSubject());
        //获取代理类对象
        Subject proxySubject = (Subject) Proxy.newProxyInstance(Main.class.getClassLoader(), new Class[]{Subject.class}, handler);
        //调用目标方法
        proxySubject.request();
        proxySubject.response();

        System.out.println("实现方式2：。。。。。。。。。。。。。。。。。。。。。。。。。。。");
        //创建目标
        IUserDao target = new UserDao();
        System.out.println("目标对象：" + target.getClass());
        //代理对象
        IUserDao proxyInstance = (IUserDao)new ProxyFactory(target).getProxyInstance();
        System.out.println("代理对象："+proxyInstance.getClass());
        proxyInstance.save();
    }
}
