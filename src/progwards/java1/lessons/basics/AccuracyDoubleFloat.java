package ru.progwards.java1.lessons.basics;

public class AccuracyDoubleFloat {
    static double pi = 3.14;
    static double r = 6371.2;

    public static double volumeBallDouble(double radius) {
        double volume = (4 * pi * r * r * r) / 3;
        return volume;
    }

    public static float volumeBallFloat(float radius) {
        float volume = (float) ((4 * pi * r * r * r) / 3);
        return volume;
    }

    public static double calculateAccuracy(double radius) {
        double difference = volumeBallDouble(r) - volumeBallFloat((float) r);
        return difference;
    }

    public static void main(String[] args) {
        AccuracyDoubleFloat third = new AccuracyDoubleFloat();
        System.out.println(third.volumeBallDouble(r));
        System.out.println(third.volumeBallFloat((float) r));
        System.out.println(third.calculateAccuracy(r));
    }
}
