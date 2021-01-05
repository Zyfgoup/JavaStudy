package DemoTest;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * @Author Zyfgoup
 * @Date 2020/11/12 13:58
 * @Description
 */
public class TestSet {
    public static void main(String[] args) {
        List<Integer> list = new ArrayList<>();
        list.add(1);
        list.add(2);
        list.add(3);
        List<Integer> list2 = new ArrayList<>();
        list.add(2);
        list.add(3);
        list.add(4);
        Set<Integer> set = new HashSet<>();
        set.addAll(list);
        set.addAll(list2);
        set.forEach(integer -> System.out.println(integer));

        TestList  testList = null;
        System.out.println();
    }
}
