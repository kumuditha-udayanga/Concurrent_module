package _3_AdvanceThreadConcepts.DeadlockScenario;

public class DeadLockDemo {
    public static final Object Lock1 = new Object();
    public static final Object Lock2 = new Object();

    public static void main(String[] args) {
        Thread thread1 = new Thread(new Runnable() {
            @Override
            public void run() {
                synchronized (Lock1) {
                    System.out.println("Thread1: Holding Lock1...");
                    try {
                        Thread.sleep(10);
                    } catch (InterruptedException e) {
//                        e.printStackTrace();
                    }
                    System.out.println("Thread1: Waiting for Lock2...");
                    synchronized (Lock2) {
                        System.out.println("Thread1: Holding Lock1 & Lock2...");
                    }
                }
            }
        });

        Thread thread2 = new Thread(new Runnable() {
            @Override
            public void run() {
                synchronized (Lock1) {
                    System.out.println("Thread2: Holding Lock2...");
                    try {
                        Thread.sleep(10);
                    } catch (InterruptedException e) {
//                        e.printStackTrace();
                    }
                    System.out.println("Thread2: Waiting for Lock1...");
                    synchronized (Lock2) {
                        System.out.println("Thread2: Holding Lock2 and Lock1...");
                    }
                }
            }
        });
        thread1.start();
        thread2.start();
    }
}
