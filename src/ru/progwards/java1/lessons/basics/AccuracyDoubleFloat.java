package ru.progwards.java1.lessons.basics;

public class AccuracyDoubleFloat {
    static double pi = 3.14;

    public static void main(String[] args) {
        AccuracyDoubleFloat one = new AccuracyDoubleFloat();
        System.out.println( one.volumeBallDouble(6371.2));
        System.out.println(one.volumeBallFloat((float) 6371.2));
        System.out.println(one.calculateAccuracy(6371.2));
    }

    public static double volumeBallDouble(double radius) {
        double V = 4 / (3 * pi * (radius * radius * radius));
        return V;
    }

    public static float volumeBallFloat(float radius) {
        float V = (float) (4 / (3 * pi * radius * radius * radius));
        return V;
    }

    public static double calculateAccuracy(double radius) {
        double gap = volumeBallDouble(radius) - volumeBallFloat((float) radius);
        return gap;
    }
}
