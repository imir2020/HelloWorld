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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if(o != null || getClass() == o.getClass())return  true;
        Animal animal = (Animal) o;
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

    public static void main(String[] args) {
        Cow one = new Cow(420);
        one.getFood1kgPrice();
        System.out.println(one.getFood1kgPrice());
    }
}
