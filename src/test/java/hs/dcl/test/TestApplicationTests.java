package hs.dcl.test;

import hs.dcl.test.common.ErrorEnum;
import org.apache.commons.lang3.math.NumberUtils;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.math.BigDecimal;
import java.text.DecimalFormat;
import java.text.MessageFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@SpringBootTest
class TestApplicationTests {

    @Test
    void contextLoads() {

        String cts = String.valueOf(System.currentTimeMillis());
        System.out.println(cts);
    }

    @Test
    void date(){

        DecimalFormat format = new DecimalFormat("00");
        String str = MessageFormat.format("{0}{1}{2}",
                1,
                format.format(7),
                format.format(17));
        int i = NumberUtils.toInt(str, -1);
        System.out.println(i);

        String msg = MessageFormat.format("{0}{1}","未知", "异常");
    }

    @Test
    void time(){
        List<Addtest> list = new ArrayList<>();
        BigDecimal a = new BigDecimal(1);
        BigDecimal a1 = new BigDecimal(2);
        BigDecimal a2 = new BigDecimal(3);
        BigDecimal a3 = new BigDecimal(4);
        Addtest addtest = new Addtest();
        addtest.setExerciseAvgPrice(a);
        list.add(addtest);
        Addtest addtest1 = new Addtest();
        addtest1.setExerciseAvgPrice(a1);
        list.add(addtest1);
        Addtest addtest2 = new Addtest();
        addtest2.setExerciseAvgPrice(a2);
        list.add(addtest2);
        Addtest addtest3 = new Addtest();
        addtest3.setExerciseAvgPrice(a3);
        list.add(addtest3);

        Addtest addtest4 = new Addtest();
        BigDecimal exerciseAvgPrice = new BigDecimal(0);
        BigDecimal addd = new BigDecimal(0);
        for(Addtest ddtest : list){
            BigDecimal add = ddtest.getExerciseAvgPrice();
            if(null == add){
                add = addd;
            }

            BigDecimal add1 = exerciseAvgPrice.add(add);
            exerciseAvgPrice = add1;
        }
        addtest4.setExerciseAvgPrice(exerciseAvgPrice);

        System.out.println(exerciseAvgPrice);
    }

    @Test
    void adsa(){


    }

}
