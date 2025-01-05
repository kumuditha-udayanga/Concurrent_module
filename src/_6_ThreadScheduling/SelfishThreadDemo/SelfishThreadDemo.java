package _6_ThreadScheduling.SelfishThreadDemo;

public class SelfishThreadDemo {
    public static void main(String[] args) {
        Thread selfishThread = new Thread(new SelfishTask(), "Selfish Thread");
        Thread politeThread = new Thread(new PoliteTask(), "Polite Thread");

        selfishThread.start();
        politeThread.start();
    }

    static class SelfishTask implements Runnable {
        @Override
        public void run() {
            for (int i = 0; i < 5; i++) {
                System.out.println(Thread.currentThread().getName() + " is monopolizing CPU");
            }
        }
    }

    static class PoliteTask implements Runnable {
        @Override
        public void run() {
            for (int i = 0; i < 5; i++) {
                System.out.println(Thread.currentThread().getName() + " is yielding.");
                Thread.yield();
            }
        }
    }
}
