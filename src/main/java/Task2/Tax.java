package Task2;

import java.util.concurrent.atomic.LongAdder;

public class Tax {
    private LongAdder adder = new LongAdder();

    public void addSum(long sum) {
        adder.add(sum);
    }
    public long getAllSum() {
        return adder.sum();
    }
}
