package _3_AdvanceThreadConcepts;

public class CountDownThread extends Thread{
    @Override
    public void run() {
//        try {
//            Thread.sleep(1000);
//        } catch (InterruptedException e) {
//            e.printStackTrace();
//        }
        for(int i = 5; i >= 1; i--){
            System.out.println("CountDown: "+ i);
            try {
                Thread.sleep(500);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
