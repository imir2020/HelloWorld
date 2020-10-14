package ru.progwards.java1.lessons.interfaces;


public class Cow extends Animal {
    double coeff = 0.05;
    public Cow(double weight) {
        super(weight);
    }

    @Override
    public double getFood1kgPrice() {
        return 50;
    }

    @Override
    public AnimalKind getKind() {
        return AnimalKind.COW;
    }

    @Override
    public FoodKind getFoodKind() {
        return FoodKind.HAY;
    }

    @Override
    public double getFoodCoeff() {
        return coeff;
    }

    public static void main(String[] args) {
        Cow one = new Cow(350);
        System.out.println(one.getFood1kgPrice());
    }
}
