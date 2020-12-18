package Task2;

public class Main {
    public static void main(String[] args) throws InterruptedException {
        Tax tax = new Tax();
        Shop shop1 = new Shop();
        Shop shop2 = new Shop();
        Shop shop3 = new Shop();

        Thread thread1 = new Thread(() -> {
            long sum = shop1.calcAllPrice();
            tax.addSum(sum);
        });

        Thread thread2 = new Thread(() -> {
            long sum = shop2.calcAllPrice();
            tax.addSum(sum);
        });

        Thread thread3 = new Thread(() -> {
            long sum = shop3.calcAllPrice();
            tax.addSum(sum);
        });

        thread1.start();
        thread2.start();
        thread3.start();

        thread1.join();
        thread2.join();
        thread3.join();

        System.out.println("Общая сумма за день: " + tax.getAllSum());
    }
}
