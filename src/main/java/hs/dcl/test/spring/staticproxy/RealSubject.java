package hs.dcl.test.spring.staticproxy;

/**
 * @author dacl30868
 * @description: 目标类
 * @date 2020/9/8 14:09
 */
public class RealSubject implements Subject{

    @Override
    public void request() {

        System.out.println("执行目标对象的request方法......");
    }

    @Override
    public void response() {
        System.out.println("执行目标对象的response方法......");
    }
}
