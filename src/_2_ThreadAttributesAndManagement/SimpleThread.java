package _2_ThreadAttributesAndManagement;

public class SimpleThread extends Thread{
    public SimpleThread(String name) {
        super(name);
    }

    @Override
    public void run() {
        for(int i = 0; i <= 5; i++) {
            System.out.println(getName() +": "+ i);
            try {
                Thread.sleep(500);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
