package ru.progwards.java1.lessons.classes;

public class ComplexNum {
    int a;
    int b;
    int c;
    int d;
    int z;

    public ComplexNum(int a, int b) {
        this.a = a;
        this.b = b;
    }

    public String toString() {
        return a + "+" + b + "i";
    }

    public ComplexNum add(ComplexNum num) {
        num.a = a + num.a;
        num.b = b + num.b;
        return num;
    }

    public ComplexNum sub(ComplexNum num) {
        num.a = a - num.a;
        num.b = b - num.b;
        return num;
    }

    public ComplexNum mul(ComplexNum num) {
        int temp;
        temp = (a * num.a - b * num.b);
        num.b = (b * num.a + a * num.b);
        num.a = temp;
        return num;
    }

    public ComplexNum div(ComplexNum num) {
        int temp;
        temp = (a * num.a + b * num.b) / (num.a * num.a + num.b * num.b);
        num.b = ((b * num.a - a * num.b) / (num.a * num.a + num.b * num.b));
        num.a = temp;
        System.out.println(num.a );
        return num;
    }

    public static void main(String[] args) {
        ComplexNum second = new ComplexNum(1000, 1000);
        ComplexNum second2 = new ComplexNum(100, 100);
        System.out.println(second.toString());
        System.out.println(second.div(second2));
        System.out.println(second.mul(second2));
    }
}
