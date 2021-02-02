package Task1;

public class WaitNotify implements Runnable{
    private static volatile char c = 'A';
    private static Object charTyper = new Object();
    private char currentChar;
    private char nextChar;

    public WaitNotify(char currentLetter, char nextChar) {
        this.currentChar = currentLetter;
        this.nextChar = nextChar;
    }

    @Override
    public void run() {
        int i = 0;
        do { synchronized (charTyper) {
                try {
                    while (c != currentChar)
                        charTyper.wait();
                    System.out.print(currentChar);
                    c = nextChar;
                    charTyper.notifyAll();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                } finally {
                    i++;
                }
            }
        } while (i < 5);
    }
}
