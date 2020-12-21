package ru.progwards.java1.lessons.sets;

import java.util.ArrayList;
import java.util.List;

public class Shop {
    private List<Product> products;//Подумать, нужно ли инциализировать множество в классе, или в конструкторе.

    public Shop(List<Product> products) {
        this.products = products;
        //products = new ArrayList<>();
    }

    public List<Product> getProducts() {
        return products;
    }

    public static void main(String[] args) {

    }
}
