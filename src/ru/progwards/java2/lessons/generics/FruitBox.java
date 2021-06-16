package ru.progwards.java2.lessons.generics;

import java.util.ArrayList;

public class FruitBox<T extends Fruit> {//extends ArrayList
   private ArrayList<T> box = new ArrayList<>();
    private float weight = 0.5f;

    public FruitBox() {

    }

    ArrayList<T> add(T example) {
        box.add(example);
        return box;
    }

    float getWeight() {
        return weight;
    }

    //Создать в методе исключение UnsupportedOperationException, и его обработку.
    FruitBox<T> moveTo(FruitBox<T> example) {
        try {
            example.box.addAll(this.box);
            this.box.clear();
        } catch (UnsupportedOperationException e) {
            e.printStackTrace();
        }
        return example;
    }

    float compareTo(FruitBox<? extends Fruit> object) {
        int quantity = this.box.size();
        int paramQuant = object.box.size();
        if (((quantity * this.box.get(0).getWeight()) - (paramQuant * object.box.get(0).getWeight())) == 0) return 0;
        return quantity * this.box.get(0).getWeight() < paramQuant * object.box.get(0).getWeight() ? -1 : 1;
    }

    public static void main(String[] args) {
        FruitBox<Orange> one = new FruitBox<>();
        FruitBox<Apple> two = new FruitBox<>();
        FruitBox<Orange> three = new FruitBox<>();
        three.add(new Orange());
        three.add(new Orange());
        three.add(new Orange());
        two.add(new Apple());
        two.add(new Apple());
        two.add(new Apple());
        one.add(new Orange());
        one.add(new Orange());
        one.add(new Orange());
        System.out.println(two.compareTo(one));
        one.moveTo(three);
        System.out.println(three.box.size());
    }
}
