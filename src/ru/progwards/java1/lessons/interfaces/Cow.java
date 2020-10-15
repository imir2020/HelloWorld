package ru.progwards.java1.lessons.interfaces;

public class Cow extends Animal {
    double coeff = 0.05;

    public Cow(double weight) {
        super(weight);
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

}
