package hs.dcl.test.controller.javabase;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.prefs.Preferences;

public class ListDeleteController {

    public static void main(String[] args) {
    List<String> list = new ArrayList<>(Arrays.asList("a1", "ab2", "a3", "ab4", "a5", "ab6", "a7", "ab8", "a9"));
    // 迭代删除方式一
        for (String str : list) {
            System.out.println(str);
            if (str.contains("b")) {
                list.remove(str);
            }
        }
    // 迭代删除方式二
        int size = list.size();
        for (int i = 0; i < size; i++) {
            String str = list.get(i);
            System.out.println(str);
            if (str.contains("b")) {
                list.remove(i);
//                size--;
//                 i--;
            }
        }
    // 迭代删除方式三
        for (int i = 0; i < list.size(); i++) {
            String str = list.get(i);
            System.out.println(str);
            if (str.contains("b")) {
                list.remove(i);
            }
        }
    // 迭代删除方式四
        for (Iterator<String> ite = list.iterator(); ite.hasNext();) {
            String str = ite.next();
            System.out.println(str);
            if (str.contains("b")) {
                ite.remove();
            }
        }
    // 迭代删除方式五
        for (Iterator<String> ite = list.iterator(); ite.hasNext();) {
            String str = ite.next();
            if (str.contains("b")) {
                list.remove(str);
            }
        }

    }
}
