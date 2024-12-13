package _3_AdvanceThreadConcepts;

public class CountUpThread extends Thread{
    @Override
    public void run () {
        for (int i = 1; i <=5; i++) {
            System.out.println("CountUp: "+ i);
            try {
                Thread.sleep(500);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
