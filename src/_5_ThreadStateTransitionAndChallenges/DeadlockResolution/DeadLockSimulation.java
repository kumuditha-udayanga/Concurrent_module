package _5_ThreadStateTransitionAndChallenges.DeadlockResolution;

public class DeadLockSimulation {
    public static void main(String[] args) {
        final Object resource1 = new Object();
        final Object resource2 = new Object();

        Thread thread1 = new Thread(new DeadlockTask(resource1, resource2), "Thread-1");
        Thread thread2 = new Thread(new DeadlockTask(resource1, resource2), "Thread-2");

        thread1.start();
        thread2.start();
    }
}
