package Task2;

public class Main {
    public static void main(String[] args) throws InterruptedException {
        Tax tax = new Tax();
        Shop shop1 = new Shop(tax);
        Shop shop2 = new Shop(tax);
        Shop shop3 = new Shop(tax);

        Thread thread1 = new Thread(shop1::sendReport);

        Thread thread2 = new Thread(shop2::sendReport);

        Thread thread3 = new Thread(shop3::sendReport);

        thread1.start();
        thread2.start();
        thread3.start();

        thread1.join();
        thread2.join();
        thread3.join();

        System.out.println("Общая сумма за день: " + tax.getAllSum());
    }
}
