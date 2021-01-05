package DemoTest;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author Zyfgoup
 * @Date 2020/11/9 16:17
 * @Description
 */
public class TestList {

    public static void main(String[] args) {
        List<Integer> list = new ArrayList<>();
        list.add(3);
        list.add(5);
        list.add(9);
        List<Integer> list2 = new ArrayList<>();
        list2.add(1);
        list2.add(2);
        list2.add(3);
        list2.add(4);
        list2.add(5);
        list2.add(6);
        list2.add(7);
        list2.add(8);
        list2.add(9);
        list2.add(10);

        for(Integer i:list2){
            for(Integer i1:list){
                if(i.compareTo(i1)==0){
                    i+=10;
                    list.remove(i1);
                    System.out.println(list.size());
                    break;
                }
            }
            System.out.println(i);
        }

    }

    public String test(){
       return "1213";
    }
}
