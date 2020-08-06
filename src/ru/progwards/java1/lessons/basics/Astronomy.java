package ru.progwards.java1.lessons.basics;

public class Astronomy {
    static double pi = 3.14;
    static double earth = 6371.2;
    static double mercury = 2439.7;
    static double jupiter = 71492;

    public static void main(String[] args) {
        Astronomy astra = new Astronomy();
        System.out.println(astra.earthSquare());
        System.out.println(astra.mercurySquare());
        System.out.println(astra.jupiterSquare());
        System.out.println( astra.earthVsMercury());
        System.out.println(astra.earthVsJupiter());
    }

    public static Double sphereSquare(Double r) {
        double S = 4 * pi * r * r;
        return S;
    }

    public static Double earthSquare() {
        double planet1 = sphereSquare(earth);
        return planet1;
    }

    public static Double mercurySquare() {
        double planet2 = sphereSquare(mercury);
        return planet2;
    }

    public static Double jupiterSquare() {
        double planet3 = sphereSquare(jupiter);
        return planet3;
    }

    public static Double earthVsMercury() {
        double versus1 = earthSquare() / mercurySquare();
        return versus1;
    }


    public static Double earthVsJupiter() {
        double versus2 = earthSquare() / jupiterSquare();
        return versus2;
    }
}
