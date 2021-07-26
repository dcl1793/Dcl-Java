package hs.dcl.test.controller.javabase;

import java.util.ArrayList;
import java.util.List;

public class ListAddController {
    public static void main(String[] args) {

        List<String> source = new ArrayList<>();
        source.add("11");

        List<String> target = new ArrayList<>();
        //addAll可以添加null
        source.addAll(target);
        System.out.println(source);
    }
}
