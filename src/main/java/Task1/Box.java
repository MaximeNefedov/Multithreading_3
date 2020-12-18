package Task1;

import java.util.concurrent.atomic.AtomicInteger;

class Box {
    private volatile boolean boxStatus;
    private final int limit;
    private AtomicInteger counter = new AtomicInteger(0);
    private static final int TIME_TO_CLOSE = 2000;
    private static final int TIME_TO_OPEN = 3000;


    public Box(int limit) {
        this.limit = limit;
    }

    public void closeBox() {
        while (counter.get() < limit) {
            while (!boxStatus);
            try {
                Thread.sleep(TIME_TO_CLOSE);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            boxStatus = false;
            System.out.println(Thread.currentThread().getName() + " переключил тумблер, коробка закрылась");
        }
    }

    public void openBox() {
        while (counter.get() < limit) {
            while (boxStatus);
            try {
                Thread.sleep(TIME_TO_OPEN);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            boxStatus = true;
            System.out.println(Thread.currentThread().getName() + " переключил тумблер, коробка открылась");
            counter.incrementAndGet();
        }
    }
}
