package ru.progwards.java1.lessons.interfaces;

public class Hamster extends Animal {
    double coeff = 0.03;

    public Hamster(double weight) {
        super(weight);
    }

    @Override
    public AnimalKind getKind() {
        return AnimalKind.HAMSTER;
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
        if (this == anObject) return true;
        if (anObject == null || getClass() != anObject.getClass()) return false;
        Animal animal = (Animal) anObject;
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
    public int compareFoodPrice() {
        return super.compareFoodPrice();
    }

    @Override
    public int compareFoodPrice(Animal animal) {
        return super.compareFoodPrice(animal);
    }
    public static void sort(CompareWeight[] a) {
        Animal[] b = new Animal[a.length];
        for (int i = 0; i < a.length; i++) {
            b[i] = (Animal) a[i];
        }
        for (int i = 0; i < a.length; i++) {
            for (int j = i + 1; j < a.length; j++) {
                if (b[i].getWeight() > b[j].getWeight()) {
                    double temp;
                    temp = b[i].getWeight();
                    b[i] = b[j];
                    b[j].weight = temp;
                }
            }
            System.out.println(b[i]);//test
            System.out.println(b[i].getWeight());//test
        }
    }
}
