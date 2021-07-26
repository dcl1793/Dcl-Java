package hs.dcl.test.controller.javabase;

public class LongEqualsController {

    public static void main(String[] args) {

        /**
         * 源码中显示，Long中有一个静态的内部类LongCache，专门用于缓存-128至127之间的值，一共256个元素。
         * 如果值在[-128, 127]之间，会放在缓存里面，而超过这个范围就要new一个新的对象，
         * 也就是说==不能判断对象是否相等。当然，如果值是在[-128, 127]之间的话是测不出来什么问题的。
         */

        /**
         * 它是先通过.longValue()方法获取Long对象的基本类型long的值之后再做比较的。
         * 我们用longValue会比较容易忘记后面一个包装类调longValue方法。
         * 所以所我们最好用.eques()方法，当然也可以用.longValue()的！
         */

        Long a = 1111111L;
        Long b = 1111111L;

        System.out.println("-----------------------==方式---------------------");
        if(a == b ){
            System.out.println("a等于b");
        }else{
            System.out.println("a不等于b");
        }
        System.out.println("-----------------------equals方式---------------------");
        if(a.equals(b)){
            System.out.println("a等于b");
        }else{
            System.out.println("a不等于b");
        }
        System.out.println("----------------------longValue方式----------------------");
        if(a.longValue() == b.longValue()){
            System.out.println("a等于b");
        }else{
            System.out.println("a不等于b");
        }
    }

}
