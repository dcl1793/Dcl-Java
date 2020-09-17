package hs.dcl.test.spring.dynamicproxy;

import hs.dcl.test.spring.staticproxy.RealSubject;
import hs.dcl.test.spring.staticproxy.Subject;
import org.springframework.cglib.proxy.Enhancer;

/**
 * @author dacl30868
 * @description:
 * @date 2020/9/8 15:22
 */
public class Main1 {

    public static void main(String[] args) {

        //获取Enhancer 对象
        Enhancer enhancer = new Enhancer();

        //设置代理类的父类（目标类）
        enhancer.setSuperclass(RealSubject.class);
        //设置回调方法
        enhancer.setCallback(new MyMethodInterceptor());
        //获取代理对象
        Subject proxySubject = (Subject)enhancer.create();

        //调用目标方法
        proxySubject.request();
        proxySubject.response();
    }
}
