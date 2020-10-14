package ru.progwards.java1.lessons.interfaces;

public class Animal implements FoodCompare, CompareWeight {
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
        Animal animal = (Animal) anObject;
        if (getWeight() == ((Animal) anObject).getWeight()) {
            return true;
        }
        if (anObject == null || getClass() != anObject.getClass()) return false;

        return Double.compare(animal.getWeight(), getWeight()) == 0 &&
                Double.compare(animal.coeff, coeff) == 0;
    }

    @Override
    public int compareFoodPrice() {
        return 0;
    }


    public double getFood1kgPrice() {
        FoodKind temp = FoodKind.UNKNOWN;// не совсем правильно
        int result = 0;
        switch (temp) {
            case HAY :
                result = 20;
                break;
            case CORN:
                result = 50;
                break;
            case UNKNOWN:
                result = 0;
                break;
        }
        return  result;
    }

    public double getFoodPrice() {
        double result = calculateFoodWeight() * getFood1kgPrice();
        return result;
    }

    public int compareFoodPrice(Animal animal) {
        return Double.compare(this.getFood1kgPrice(), animal.getFood1kgPrice());
    }

    @Override
    public CompareResult compareWeight(CompareWeight smthHasWeigt) {
        Animal one = (Animal) smthHasWeigt;
        CompareResult result = null;
        if(getWeight() < one.getWeight()){
             result = CompareResult.LESS;
        }
        if(getWeight() == one.getWeight()){
            result = CompareResult.EQUAL;
        }
        if(getWeight() > one.getWeight()){
             result = CompareResult.GREATER;
        }
        return result;
    }

    public static void main(String[] args) {
        Animal one = new Animal(450);
        one.toString();
        System.out.println(one.toString());
        System.out.println(one.toStringFull());

        System.out.println(one.equals(new Duck(450)));
    }
}
