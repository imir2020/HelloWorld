package ru.progwards.java1.lessons.queues;

public class Calculate {
    public static double calculation1(){
        StackCalc one = new StackCalc();
        one.push(2.2);
        one.push(3);
        one.push(12.1);
        one.add();
        one.mul();
        return one.pop();

    }
    public static double calculation2(){
        StackCalc two = new StackCalc();
        two.push(737.22);
        two.push(24);
        two.add();
        two.push(55.6);
        two.push(12.1);
        two.sub();
        two.div();
        two.push(19);
        two.push(3.33);
        two.sub();
        two.push(87);
        two.push(2);
        two.push(13.001);
        two.push(9.2);
        two.sub();
        two.mul();
        two.add();
        two.mul();
        two.add();
        return two.pop();
    }
    public static void main(String[] args) {
        System.out.println(calculation1());
        System.out.println(calculation2());
    }
}
