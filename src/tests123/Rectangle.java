package tests123;

import java.util.Arrays;


public class Rectangle {
    private double a;
    private double b;

    public Rectangle(double a, double b) {
        this.a = a;
        this.b = b;
    }

    public double area() {
        return a * b;
    }

    public int compareTo(Rectangle anRectangle) {
        int result = 0;
        if (area() > anRectangle.area()) {
            result = 1;
        } else if (area() < anRectangle.area()) {
            result = -1;
        }
        return result;
    }
    public int arrayMax(int[] a){
        int result = 0;
        Arrays.sort(a);
        if(a.length != 0) {
            result = a[a.length - 1];
        }
        return result;
    }
    public static void main(String[] args) {
        Rectangle om = new Rectangle(2, 5);
        Rectangle to = new Rectangle(5, 2);
        System.out.println(om.compareTo(to));

    }
}
