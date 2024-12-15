package _4_NonRunnableState.BlockedStateDemo;

public class SynchronizedCounter {
    private int count = 0;

    public synchronized void increment() {
        System.out.println(Thread.currentThread().getName() + " acquired lock");
        try {
            Thread.sleep(500);
            count++;
            System.out.println(Thread.currentThread().getName() + " increment count to "+ count);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println(Thread.currentThread().getName() + " released the lock");
    }
}
