package ru.progwards.java1.lessons.queues;

import java.util.*;

public class OrderQueue {
    Comparator<Order> orderComparator = new Comparator<Order>() {
        @Override
        public int compare(Order c1, Order c2) {
            int cl1 = ((int) c1.getSum() - 1) / 10000 + 1;
            if (cl1 < 1) cl1 = 1;
            else if (cl1 > 3) cl1 = 3;
            int cl2 = ((int) c2.getSum() - 1) / 10000 + 1;
            if (cl2 < 1) cl2 = 1;
            else if (cl2 > 3) cl2 = 3;
            if (cl1 == cl2) return c1.getNum() - c2.getNum();
            return cl2 - cl1;
        }
    };
    PriorityQueue<Order> queue = new PriorityQueue<Order>(16, orderComparator);

    public void add(Order order){
        queue.add(order);
    }
    public Order get(){
        return queue.poll();

    }
    public Order getNum() {
        return queue.poll();
    }
    public static void main(String[] args) {
        OrderQueue first = new OrderQueue();
        first.add(new Order(11100.0));
        first.add(new Order(26206.0));
        first.add(new Order(11274.0));
        first.add(new Order(1892.0));
        first.add(new Order(25531.0));
        first.add(new Order(6996.0));
        first.add(new Order(1135.0));
        first.add(new Order(12454.0));
        first.add(new Order(8186.0));
        first.add(new Order(16585.0));
        first.add(new Order(15326.0));
        first.add(new Order(23366.0));
        first.add(new Order(17812.0));
        first.add(new Order(20811.0));
        first.add(new Order(19808.0));
        first.add(new Order(12714.0));
        first.add(new Order(10281.0));
        Order one = first.get();
        while (one != null) {
            System.out.println(one);
            one = first.get();
        }
    }
}
