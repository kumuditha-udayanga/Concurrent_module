package _5_ThreadStateTransitionAndChallenges.WaitingStateWithJoin;

public class WaitingStateWithJoin {
    public static void main(String[] args) {
        Thread firstThread = new Thread(()->{
            System.out.println("First thread is working");
            try {
                Thread.sleep(3000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("First thread has finished work");
        });
        Thread secondThread = new Thread(()->{
            System.out.println("Second thread is working");
            try {
                firstThread.join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("Second thread has finished working");
        });

        firstThread.start();
        secondThread.start();
    }
}
