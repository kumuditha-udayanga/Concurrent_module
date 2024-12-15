package _5_ThreadStateTransitionAndChallenges;

public class StateTransitionExercise {
    public static void main(String[] args) {
        final Object monitor = new Object();

        Thread thread = new Thread(() -> {
            synchronized (monitor) {
                try {
                    System.out.println("Thread is entering WAITING state.");
                    monitor.wait();
                    System.out.println("Thead is RUNNABLE state again");
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });

        thread.start();

        try {
            Thread.sleep(2000);
            synchronized (monitor) {
                monitor.notify();
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
     }
}
