package _3_AdvanceThreadConcepts;

public class TwoThreadsTest {
    public static void main(String[] args) {
        Thread countUp = new CountUpThread();
        Thread countDown = new CountDownThread();

        countUp.start();
        try {
            countUp.join(); // wait for countUp to finish, pause the thread until this finish
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        countDown.start();
    }
}
