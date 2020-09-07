package hs.dcl.test.controller.lambda;

import org.junit.Test;

import java.util.function.Function;

/**
 * @author dacl30868
 * @description: lambda表达式
 * @date 2020/8/3 15:13
 */
public class LambdaController {


    @Test
    public void test1(){

        InteUer inteUer = new InteUer("dcl",88);
        Function function = new Function() {
            @Override
            public Object apply(Object o) {
                return null;
            }
        };
        Object apply = function.apply(inteUer);


        Function<InteUer,String> uft = u -> u.getName();

    }

}
