package VivaPrep;

public class Main {
    public static void main (String[] args) {
        Thread thread1 = new Thread(new MyThread(), "Thread 1");
        Thread thread2 = new Thread(new MyThread(), "Thread 2");
        Thread thread3 = new Thread(new MyThread(), "Thread 3");

        thread1.start();
        thread2.start();
        thread3.start();

        try {
            thread1.join();
            thread2.join();
            thread3.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
