package hs.dcl.test.spring.staticproxy;

/**
 * @author dacl30868
 * @description:
 * @date 2020/9/8 14:17
 */
public class Main {

    public static void main(String[] args) {
        //目标对象
        Subject subject = new RealSubject();
        //代理对象，通过构造器注入目标对象
        Subject proxySubject = new ProxySubject(subject);
        proxySubject.request();
        proxySubject.response();

    }
}
