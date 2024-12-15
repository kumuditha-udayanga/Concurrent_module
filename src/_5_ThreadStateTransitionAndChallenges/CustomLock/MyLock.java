package _5_ThreadStateTransitionAndChallenges.CustomLock;

public class MyLock {
    private boolean isLocked = false;
    public synchronized void lock () {
        while (isLocked) {
            try {
                System.out.println("Waiting to release");
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        isLocked = true;
    }
    public synchronized void unlock () {
        isLocked = false;
        notify();
    }
}
