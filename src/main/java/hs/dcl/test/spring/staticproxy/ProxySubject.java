package hs.dcl.test.spring.staticproxy;

/**
 * @author dacl30868
 * @description: 代理类
 * @date 2020/9/8 14:13
 */
public class ProxySubject implements Subject{

    private Subject subject;

    public ProxySubject (Subject subject){
        this.subject = subject;
    }

    @Override
    public void request() {
        System.out.println("before 前置增强");
        subject.request();
        System.out.println("after 后置增强");
    }

    @Override
    public void response() {
        System.out.println("before 前置增强");
        subject.response();
        System.out.println("after 后置增强");
    }
}


