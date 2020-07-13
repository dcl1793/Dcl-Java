package hs.dcl.test.ioc;

import java.util.Random;

public class Test {

    public static void main(String[] args) {

        //set注入和接口注入会报错，空指针异常，因为依赖隐藏，new出的对象没有交给容器控制
//        POJO pojo = new POJO();
//        pojo.execute();

/*
        构造器注入正常
        DependA dependa = new DependA();
        POJO pojo = new POJO(dependa);
        pojo.execute();

        */

        Random random = new Random();

        int i1 = random.nextInt(100);
        int i2 = random.nextInt(200);

        System.out.println(i1);
        System.out.println(i2);

    }
}
