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

    @Override
    public boolean equals(Object anObject) {
        Animal animal = (Animal) anObject;
        if (this.toString() == animal.toString()) return true;
        if (animal == null || getClass() != animal.getClass()) return false;
        if (this.getWeight() != animal.getWeight() && getClass() == animal.getClass()) return false;
        if (animal != null || (getClass() == animal.getClass() && this.getWeight() == animal.getWeight())) return true;
        return Double.compare(animal.getWeight(), getWeight()) == 0 &&
                Double.compare(animal.coeff, coeff) == 0;
    }

    @Override
    public double getFood1kgPrice() {
        return super.getFood1kgPrice();
    }

    @Override
    public int compareFoodPrice(Animal animal) {
        return super.compareFoodPrice(animal);
    }

    public static void main(String[] args) {
        Duck one = new Duck(5);
        one.equals(new Duck(5));
        System.out.println(one.equals(new Cow(5)));
        //one.getFood1kgPrice();
        //System.out.println(one.getFood1kgPrice());
    }
}
