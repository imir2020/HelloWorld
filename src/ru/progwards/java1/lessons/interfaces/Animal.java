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
        double weightOffFood = getWeight() * getFoodCoeff();
        return weightOffFood;
    }

    public String toStringFull() {
        return "I am " + getKind() + ", eat " + getFoodKind() + " " + calculateFoodWeight();
    }



    @Override
    public boolean equals(Object anObject) {
        if (this == anObject) return true;
        if (anObject == null || getClass() != anObject.getClass()) return false;
        Animal animal = (Animal) anObject;
        if (this.getWeight() != animal.getWeight() && getClass() == animal.getClass()) return false;
        if (animal != null || (getClass() == animal.getClass() && this.getWeight() == animal.getWeight())) return true;
        return Double.compare(animal.getWeight(), getWeight()) == 0 &&
                Double.compare(animal.coeff, coeff) == 0;
    }

    @Override
    public int compareFoodPrice() {
        return 10;
    }

    public double getFood1kgPrice() {
        int result = 0;
        switch (getFoodKind()) {
            case HAY:
                result = 20;
                break;
            case CORN:
                result = 50;
                break;
            case UNKNOWN:
                result = 0;
                break;
        }
        return result;
    }

    public double getFoodPrice() {
        double result = calculateFoodWeight() * getFood1kgPrice();
        return result;
    }

    public int compareFoodPrice(Animal animal) {
        return Double.compare(this.getFoodPrice(), animal.getFoodPrice());
    }

    @Override
    public CompareResult compareWeight(CompareWeight smthHasWeigt) {
        Animal one = (Animal) smthHasWeigt;
        CompareResult result = null;
        if (getWeight() < one.getWeight()) {
            result = CompareResult.LESS;
        }
        if (getWeight() == one.getWeight()) {
            result = CompareResult.EQUAL;
        }
        if (getWeight() > one.getWeight()) {
            result = CompareResult.GREATER;
        }
        return result;
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
