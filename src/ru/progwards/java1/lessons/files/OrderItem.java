package ru.progwards.java1.lessons.files;

public class OrderItem {
    public String googsName; // наименование товара
    public int count; // количество
    public double price; // цена за единицу

    @Override
    public String toString() {
        return "\nOrderItem{" + googsName + ", count=" + count + ", price=" + price + '}';
    }
    public static void main(String[] args) {

    }
}
