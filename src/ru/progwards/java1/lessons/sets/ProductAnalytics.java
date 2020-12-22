package ru.progwards.java1.lessons.sets;

import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

public class ProductAnalytics {
    private List<Shop> shops;
    private List<Product> products;

    public ProductAnalytics(List<Shop> shops, List<Product> products) {
        this.shops = shops;
        this.products = products;
    }

    public Set<Product> existInAll() {
        Set<Product> productList = new HashSet(products);
        Iterator it = shops.iterator();
        while (it.hasNext()) {
            productList.retainAll(new HashSet<Product>(((Shop) it.next()).getProducts()));
        }
        return productList;
    }

    public Set<Product> existAtListInOne() {


        return null;
    }

    public Set<Product> notExistInShops() {


        return null;
    }

    public Set<Product> existOnlyInOne() {

        return null;
    }

    public static void main(String[] args) {

    }

}
