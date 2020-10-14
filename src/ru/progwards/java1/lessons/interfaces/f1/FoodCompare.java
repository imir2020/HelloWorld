package ru.progwards.java1.lessons.interfaces.f1;

import ru.progwards.java1.lessons.interfaces.Animal;

public interface FoodCompare {
    default int compareFoodPrice(Animal animal) {
        return 0;
    }
}
