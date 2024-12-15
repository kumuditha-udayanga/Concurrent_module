package _4_NonRunnableState.BlockedStateDemo;

public class BlockedStateDemo {
    public static void main(String[] args) {
        final SynchronizedCounter counter = new SynchronizedCounter();

        Thread thread1 = new Thread(()-> counter.increment(), "Thread-1");
        Thread thread2 = new Thread(()-> counter.increment(), "Thread-2");

        thread1.start();
        thread2.start();
    }
}
