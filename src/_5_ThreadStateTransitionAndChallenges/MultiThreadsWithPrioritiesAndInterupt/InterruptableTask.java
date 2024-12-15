package _5_ThreadStateTransitionAndChallenges.MultiThreadsWithPrioritiesAndInterupt;

public class InterruptableTask implements  Runnable{
    @Override
    public void run() {
        while (true) {
            try {
                System.out.println(Thread.currentThread().getName() + " is working");
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                System.out.println(Thread.currentThread().getName() + " is interrupted");
                cleanup();
                break;
            }
        }
    }

    private void cleanup() {
        System.out.println(Thread.currentThread().getName() + " is cleaning up resources.");
    }
}
