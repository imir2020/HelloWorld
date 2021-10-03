package test456;

import java.util.ArrayList;
import java.util.List;

/*
Этот класс нужен для тестирования возможностей указателей.
 */
public class S {
    S one;
    S two;

    public static void main(String[] args) {
        S rt = new S();
        //System.out.println(rt);
        S tail;
        tail = rt;
        //System.out.println(tail);
        tail.one = rt;
       // System.out.println(tail.one);
        S tr = new S();
        tail = tr;
        //System.out.println(tail);
        tail.two = tr;
       // System.out.println(tail.two);
        //System.out.println(tail);
        List list = List.of(23, 45, 65, 654, 345);
       // System.out.println(tail);
        System.out.println(list);
    }
}
