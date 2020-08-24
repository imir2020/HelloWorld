package ru.progwards.java1.lessons.classes;

public class Animal {
    double weight;
    double coeff = 0.02;

    enum AnimalKind {
        ANIMAL, COW, HAMSTER, DUCK;
    }

    enum FoodKind {
        UNKNOWN, HAY, CORN;
    }

    public Animal(double weight) {
        this.weight = weight;
    }

    public AnimalKind getKind() {
        return AnimalKind.ANIMAL;
    }

    public FoodKind getFoodKind() {
        return FoodKind.UNKNOWN;
    }

    @Override
    public String toString() {
        return "I am " + getKind() + " eat " + getFoodKind();
    }

    public double getWeight() {
        return weight;
    }

    public double getFoodCoeff() {
        return coeff;
    }

    public double calculateFoodWeight() {
        double weightOffFood = getWeight() * getFoodCoeff();
        return weightOffFood;
    }

    public String toStringFull(){
        return "I am " + getKind() + ", eat " + getFoodKind() + " " + calculateFoodWeight();
    }

    public static void main(String[] args) {
        Animal one = new Animal(450);
        one.toString();
        System.out.println(one.toString());
        System.out.println(one.toStringFull());
    }
}
