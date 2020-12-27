package ru.progwards.java1.lessons.sets;

import java.util.*;

public class ProductAnalytics {
    private List<Shop> shops;
    private List<Product> allProducts;;

    public ProductAnalytics(List<Shop> shops, List<Product> products) {
        this.shops = shops;
        this.allProducts = products;
    }

    public Set<Product> existInAll() {
        if (allProducts == null || allProducts.size() == 0) return new HashSet<>();
        if (shops == null || shops.size() == 0) return new HashSet<>();
        Set<Product> productList = new HashSet(allProducts);
        Iterator it = shops.iterator();
        while (it.hasNext()) {
            productList.retainAll(new HashSet<>(((Shop) it.next()).getProducts()));
        }
        return productList;
    }

    public Set<Product> existAtListInOne() {
        if (allProducts == null || allProducts.size() == 0) return new HashSet<>();
        Iterator it = shops.iterator();
        Set<Product> productList = new HashSet(((Shop) it.next()).getProducts());

        while (it.hasNext()) {
            productList.addAll(new HashSet<>(((Shop) it.next()).getProducts()));
        }
        productList.retainAll(allProducts);

        return productList;
    }

    public Set<Product> notExistInShops() {
        if (allProducts == null || allProducts.size() == 0) return new HashSet<>();

        Set<Product> productList = new HashSet(allProducts);
        if (shops == null || shops.size() == 0) return productList;

        Iterator it = shops.iterator();
        while (it.hasNext()) {
            productList.removeAll(new HashSet<Product>(((Shop) it.next()).getProducts()));
        }
        return productList;

    }

    public Set<Product> existOnlyInOne() {
        Set<Product> productList = new HashSet<Product>();
        if (allProducts == null || allProducts.size() == 0) return productList;
        if (shops == null || shops.size() == 0) return productList;
        for (int i = 0; i < shops.size(); i++) {
            Set<Product> productsBefore = new HashSet<Product>();
            Set<Product> productsOne = new HashSet<Product>();
            Set<Product> productsAfter;
            Iterator it = shops.iterator();
            for (int k = 0; k < shops.size(); k++) {
                productsAfter = new HashSet<Product>(((Shop) it.next()).getProducts());
                productsAfter.retainAll(allProducts);
                if (k < i) {
                    productsBefore.addAll(productsAfter);
                } else if (k == i) {
                    productsOne = productsAfter;
                    productsOne.removeAll(productsBefore);
                } else {
                    productsOne.removeAll(productsAfter);
                }
            }
            productList.addAll(productsOne);
        }
        return productList;
    }

    public static void main(String[] args) {
        Product p1 = new Product("part-1");
        Product p2 = new Product("part-2");
        Product p3 = new Product("part-3");
        Product p4 = new Product("part-4");
        Product p5 = new Product("part-5");
        Product p6 = new Product("part-6");
        Product p7 = new Product("part-7");
        Product p8 = new Product("part-8");
        Product p9 = new Product("part-9");
        Product p10 = new Product("part-10");
        Shop s1 = new Shop(new ArrayList(Arrays.asList(p2, p7, p8, p10)));
        Shop s2 = new Shop(new ArrayList(Arrays.asList(p1, p4, p6, p10)));
        Shop s3 = new Shop(new ArrayList(Arrays.asList(p1, p4, p5, p10)));
        List<Shop> ss = new ArrayList(Arrays.asList(s1, s2, s3));
        List<Product> pa = new ArrayList(Arrays.asList(p5, p7, p8, p10));
        ProductAnalytics productAnalytics = new ProductAnalytics(ss, pa);
        System.out.println(productAnalytics.existOnlyInOne());
    }

}
