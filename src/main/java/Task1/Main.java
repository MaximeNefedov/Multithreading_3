package Task1;

public class Main {
    public static void main(String[] args) {
        Box box = new Box(5);
        new Thread(box::closeBox, "Тот, сидит в коробке,").start();
        new Thread(box::openBox, "Тот, кто пытается открыть коробку,").start();
    }
}
