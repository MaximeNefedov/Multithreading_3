package Task2;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Shop {
    private List<Long> productsPrice = new ArrayList<>();
    private Tax tax;

    public Shop(Tax tax) {
        this.tax = tax;
        Random random = new Random();
        int size = random.nextInt(100);
        for (int i = 0; i < size; i++) {
            productsPrice.add((long) random.nextInt(10_000));
        }
    }
// Для проверки корректности

    /*public Shop(Tax tax) {
        this.tax = tax;
        productsPrice.add(2300L);
        productsPrice.add(700L);
        productsPrice.add(2000L);
        productsPrice.add(2000L);

    }*/

    public void sendReport() {
        for (Long x : productsPrice) {
            tax.addSum(x);
        }
    }
}
