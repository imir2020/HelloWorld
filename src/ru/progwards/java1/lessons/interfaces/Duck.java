package ru.progwards.java1.lessons.interfaces;

import ru.progwards.java1.lessons.classes.Animal;

public class Duck extends Animal {
    double coeff = 0.04;

    public Duck(double weight) {
        super(weight);
    }

    @Override
    public AnimalKind getKind() {
        return AnimalKind.DUCK;
    }

    @Override
    public FoodKind getFoodKind() {
        return FoodKind.CORN;
    }

    @Override
    public double getFoodCoeff() {
        return coeff;
    }
}
