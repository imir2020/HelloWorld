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
        return a + " + " + b + "i";
    }

    public ComplexNum add(ComplexNum num) {
        num.z = (num.a + num.c) + (num.b + num.d);
        return num;
    }

    public ComplexNum sub(ComplexNum num) {
        num.z = (num.a - num.c) + (num.b - num.d);
        return num;
    }

    public ComplexNum mul(ComplexNum num) {
        num.z = (num.a *num.c - num.b * num.d) + (num.b * num.c + num.a * num.d);
        return  num;
    }

    public ComplexNum div(ComplexNum num){
        num.z = (num.a *num.c + num.b * num.d)/(num.c * num.c + num.d * num.d)
                + ((num.b *num.c - num.a *num.d)/(num.c * num.c + num.d * num.d));
        return num;
    }

    public static void main(String[] args) {
        ComplexNum second = new ComplexNum(24, 94);
        System.out.println(second.toString());
        System.out.println(second.add(new ComplexNum(53, 75)));
        System.out.println();
    }
}
