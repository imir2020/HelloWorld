package ru.progwards.java1.lessons.interfaces;

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

    public static void main(String[] args) {
        Duck one = new Duck(5);
        one.equals(new Duck(5));
        System.out.println(one.equals(new Duck(5)));
        //one.getFood1kgPrice();
        //System.out.println(one.getFood1kgPrice());
    }
}
