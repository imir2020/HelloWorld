package ru.progwards.java2.lessons.recursion;

import java.time.Instant;

public class Goods {
    String name;
    String number;
    int available;
    double price;
    Instant expired;

    public Goods() {
    }

    public Goods(String name, String number, int available, double price, Instant expired) {
        this.name = name;
        this.number = number;
        this.available = available;
        this.price = price;
        this.expired = expired;//Временно убрал для облегчения тестов

    }


    public String getNumber() {
        return number;
    }

    public int getAvailable() {
        return available;
    }

    public static void main(String[] args) {

    }
}
