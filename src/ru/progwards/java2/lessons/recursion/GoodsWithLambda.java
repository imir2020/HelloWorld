package ru.progwards.java2.lessons.recursion;

import java.time.Instant;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class GoodsWithLambda {
    List<Goods> list;

    public GoodsWithLambda() {
    }

    public void setGoods(List<Goods> list) {
        this.list = list;
    }

    //вернуть список, отсортированный по наименованию
    public List<Goods> sortByName() {
        List<Goods> result = list.stream().sorted(Comparator.comparing(e -> e.name)).collect(Collectors.toList());
        return result;
    }

    //вернуть список, отсортированный по артикулу, без учета регистра
    public List<Goods> sortByNumber() {
        List<Goods> result = list.stream().sorted((e, o) -> e.number.compareToIgnoreCase(o.number))
                .collect(Collectors.toList());
        return result;
    }

    //вернуть список, отсортированный по первым 3-м символам артикула, без учета регистра
    public List<Goods> sortByPartNumber() {
        List<Goods> result = list.stream().sorted((e, o) -> e.number.substring(0, 3)
                .compareToIgnoreCase(o.number.substring(0, 3)))
                .collect(Collectors.toList());
        return result;
    }

    //вернуть список, отсортированный по количеству, а для одинакового количества, по артикулу, без учета регистра
    //если одиннаково колво то сортировать по  ариткулу
    //это в копмараторе прописать нужно
    public List<Goods> sortByAvailabilityAndNumber() {
        Comparator<Goods> goodsComparator = Comparator.comparing(Goods::getAvailable).thenComparing(Goods::getNumber);
        List<Goods> result = list.stream().sorted(goodsComparator).collect(Collectors.toList());
        return result;
    }

    //вернуть список, с товаром, который будет просрочен после указанной даты, отсортированный по дате годности
    //Переделать конструктор, или сделать дополнительный конструктор класса товаров, чтобы туда передавались товары с нормальной датой, без миллисекунд. - нужно попробовать.
    //Узнать, передавать времяв милисекундах, или их нужно преобразовывать?
    //Протестировать этот метод
    public List<Goods> expiredAfter(Instant date) {
        List<Goods> result = list.stream().sorted(Comparator.comparing(e ->e.expired))
                .filter(e -> e.expired.isBefore(date))
                .collect(Collectors.toList());
        return null;
    }

    //вернуть список, с товаром, количество на складе которого меньше указанного, отсортированный по количеству
    //Протестировать данный метод.
    public List<Goods> сountLess(int count) {
        List<Goods> result = list.stream().filter(e -> e.available < count)
                .sorted(Comparator.comparing(e -> e.available))
                .collect(Collectors.toList());
        return result;
    }

    //вернуть список, с товаром, количество на складе которого больше count1 и меньше count2, отсортированный по количеству
    //Протестировать этот метод
    public List<Goods> сountBetween(int count1, int count2) {
        List<Goods> result = list.stream().filter(e -> (e.available > count1)&&(e.available < count2))
                .sorted(Comparator.comparing(e -> e.available))
                .collect(Collectors.toList());
        return null;
    }


    public static void main(String[] args) {
        List<Goods> list = new ArrayList<>(List.of(
                new Goods("A", "aaaa2", 18, 6, Instant.ofEpochMilli(234567)),
                new Goods("y", "aaaa1", 1854, 199,Instant.ofEpochMilli(47328)),
                new Goods("j", "aaaa4", 675, 34,Instant.ofEpochMilli(4834883)),
                new Goods("D", "caaa6", 165, 2345,Instant.ofEpochMilli(474738)),
                new Goods("Y", "aaaa4", 675, 34,Instant.ofEpochMilli(47473838)),
                new Goods("S", "aaaaa7", 165, 2345,Instant.ofEpochMilli(75743838))));
        GoodsWithLambda r = new GoodsWithLambda();
        r.setGoods(list);
        //r.sortByName();
        //System.out.println(r.sortByName());
        // r.sortByNumber();
        // System.out.println( r.sortByNumber());
        // r.sortByNumber().stream().map(p -> p.number).forEach(System.out::println);//Тест сортировки по артикулу.
        // System.out.println(r.sortByPartNumber());
        // r.sortByPartNumber().stream().map(p -> p.number).forEach(System.out::println);//Тест сортировки по артикулу, по первым 3 цифрам.
        //r.sortByAvailabilityAndNumber().stream().map(p -> p.available).forEach(System.out::println);//Тест сортировки по количеству товара и артикулу его
        // r.sortByAvailabilityAndNumber().stream().map(p -> p.number).forEach(System.out::println);//Тест сортировки по количеству товара и артикулу его
        // r.сountLess(250).stream().map(e -> e.available).forEach(System.out::println);

    }

}
