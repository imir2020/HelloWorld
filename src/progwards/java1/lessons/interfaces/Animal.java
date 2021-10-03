package ru.progwards.java1.lessons.interfaces;

public class Animal implements CompareWeight, FoodCompare {
    double weight;
    double coeff = 0.02;

    protected enum AnimalKind {
        ANIMAL, COW, HAMSTER, DUCK;
    }

    protected enum FoodKind {
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
        return "I am " + getKind() + "," + " eat " + getFoodKind();
    }

    public double getWeight() {
        return weight;
    }

    public double getFoodCoeff() {
        return coeff;
    }

    public double calculateFoodWeight() {
        return getWeight() * getFoodCoeff();
    }

    public String toStringFull() {
        return "I am " + getKind() + ", eat " + getFoodKind() + " " + calculateFoodWeight();
    }


    @Override
    public boolean equals(Object anObject) {
        if (this == anObject) return true;
        if (anObject == null || getClass() != anObject.getClass()) return false;
        Animal animal = (Animal) anObject;
        return Double.compare(animal.calculateFoodWeight(), calculateFoodWeight()) == 0;

    }

    @Override
    public int compareFoodPrice(Animal animal) {
        return Double.compare(getFoodPrice(), animal.getFoodPrice());
    }

    public double getFood1kgPrice() {
        switch (getFoodKind()) {
            case HAY:
                return 20;
            case CORN:
                return 50;
            case UNKNOWN:
                return 0;
        }
        return 0;
    }

    public double getFoodPrice() {
        return calculateFoodWeight() * getFood1kgPrice();
    }


    @Override
    public CompareResult compareWeight(CompareWeight smthHasWeigt) {
        Animal one = (Animal) smthHasWeigt;
        if (this.getWeight() < one.getWeight())
            return CompareResult.LESS;
        else if (this.getWeight() == one.getWeight())
            return CompareResult.EQUAL;
        else
            return CompareResult.GREATER;


    }

    public static void main(String[] args) {
        Animal one = new Animal(450);
        Duck second = new Duck(4);
        Hamster third = new Hamster(1);
        //one.toString();
        // System.out.println(one.toString());
        //System.out.println(one.toStringFull());
        System.out.println(one.equals(new Cow(45)));
        System.out.println(third.equals(new Hamster(1)));
        //one.compareFoodPrice(new Cow(450));
        //System.out.println(second.compareFoodPrice(new Hamster(90)));
        //one.getFood1kgPrice();
        System.out.println(one.getFoodPrice());
    }
}
