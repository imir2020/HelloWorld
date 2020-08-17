package ru.progwards.java1.lessons.basics;

public class Astronomy {
    static double pi = 3.14;
    static double earth = 6371.2;
    static double mercury = 2439.7;
    static double jupiter = 71492;

    public static Double sphereSquare(Double r) {
        double sphere = 4 * pi * r * r;
        return sphere;
    }

    public static Double earthSquare() {
        double square = sphereSquare(earth);
        return square;
    }

    public static Double mercurySquare() {
        double square = sphereSquare(mercury);
        return square;
    }

    public static Double jupiterSquare() {
        double square = sphereSquare(jupiter);
        return square;
    }

    public static Double earthVsMercury() {
        double versus = earthSquare() / mercurySquare();
        return versus;
    }

    public static Double earthVsJupiter() {
        double versus = earthSquare() / jupiterSquare();
        return versus;
    }

    public static void main(String[] args) {
        Astronomy second = new Astronomy();
        System.out.println(second.earthSquare());
        System.out.println(second.mercurySquare());
        System.out.println(second.jupiterSquare());
        System.out.println(second.earthVsMercury());
        System.out.println(second.earthVsJupiter());
    }
}
