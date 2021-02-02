package Task1;

public class Main {
    public static void main(String[] args) {
        new Thread(new WaitNotify('A', 'B')).start();
        new Thread(new WaitNotify('B', 'C')).start();
        new Thread(new WaitNotify('C', 'A')).start();
    }
}
