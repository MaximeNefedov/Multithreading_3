package Task2;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.Random;

public class Shop {
    List<Long> productsPrice = new ArrayList<>();
    Random random = new Random();

    public Shop() {
        int size = random.nextInt(10);
        for (int i = 0; i < size; i++) {
            productsPrice.add((long) random.nextInt(10_000));
        }
    }

    public long calcAllPrice() {
        Optional<Long> reduce = productsPrice.stream().reduce(Long::sum);
        return reduce.orElse(0L);
    }
}
