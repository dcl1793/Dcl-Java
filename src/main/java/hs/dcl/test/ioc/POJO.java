package hs.dcl.test.ioc;

import org.springframework.beans.factory.annotation.Autowired;

public class POJO {

    //接口注入
//    @Autowired
//    private A a;
//

//    set方法注入
//    private A a;
//
//    @Autowired
//    public void setA(A a){
//        this.a = a;
//    }
//
//    public A getA() {
//        return a;
//    }

    public POJO() {

    }

    //构造器注入
    private DependA dependa;

    @Autowired
    public POJO(DependA a){
        this.dependa = a;
    }

    public void execute(){
        dependa.a();
    }
}
