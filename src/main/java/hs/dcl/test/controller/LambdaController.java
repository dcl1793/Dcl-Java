package hs.dcl.test.controller;

import hs.dcl.test.model.Person;
import hs.dcl.test.util.ExcelUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.IntSummaryStatistics;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @author dacl30868
 * @description: lambda表达式测试
 * @date 2020/7/16 19:18
 */
@RestController
@RequestMapping(value = "/lambda")
public class LambdaController {


    /**
     * 利用stream().forEach()遍历集合
     */
    @RequestMapping(value = "/lambda1", method = RequestMethod.GET)
    public void lambda1(){
        List<String> list = new ArrayList<String>();
        list.add("djk");
        list.add("djk1");
        list.add("djk12");
        list.add("djk123");
        //利用stream().forEach()遍历集合
        list.stream().forEach(item->{System.out.print(item+" ");});
    }

    /**
     * 利用stream().map()对List进行大写处理，并给另外一个List赋值,并对其遍历
     */
    @RequestMapping(value = "/lambda2", method = RequestMethod.GET)
    public void lambda2(){
        List<String> list = new ArrayList<String>();
        list.add("djk");
        list.add("djk1");
        list.add("djk12");
        list.add("djk123");
        List<String> list4 = new ArrayList<String>();
        list4 = list.stream().map(item->item.toUpperCase()).collect(Collectors.toList());
        list4.stream().forEach(item->{System.out.println(item);});
    }

    /**
     * 利用stream().filter()对List进行过滤处理，并给另一个list赋值，并对其遍历
     */
    @RequestMapping(value = "/lambda3", method = RequestMethod.GET)
    public void lambda3(){
        List<String> list = new ArrayList<String>();
        list.add("djk");
        list.add("djk1");
        list.add("djk12");
        list.add("djk123");
        List<String> list3 = new ArrayList<String>();
        list3 = list.stream().filter(item->!item.equals("djk")).collect(Collectors.toList());
        list3.stream().forEach(item->{System.out.println(item);});
    }

    /**
     * 求某一个数列的最大值、最小值、和、平均值、数列元素数
     */

    @RequestMapping(value = "/lambda4", method = RequestMethod.GET)
    public void lambda4(){
        List<Integer> listint = new ArrayList<Integer>();
        listint.add(1);
        listint.add(2);
        listint.add(3);
        listint.add(4);
        listint.add(5);
        IntSummaryStatistics stat = listint.stream().mapToInt((item)->item).summaryStatistics();
        System.out.println("max:"+stat.getMax());
        System.out.println("min:"+stat.getMin());
        System.out.println("sum:"+stat.getSum());
        System.out.println("count:"+stat.getCount());
        System.out.println("average:"+stat.getAverage());
    }
}
