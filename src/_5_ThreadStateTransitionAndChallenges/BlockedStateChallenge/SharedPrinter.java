package _5_ThreadStateTransitionAndChallenges.BlockedStateChallenge;

public class SharedPrinter {
    public synchronized void printDocument(String document) {
        System.out.println(Thread.currentThread().getName() + " is printing: " + document);
        try {
            Thread.sleep(5000); // Simulate time taken to print
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println(Thread.currentThread().getName() + " finished printing.");
    }

}
