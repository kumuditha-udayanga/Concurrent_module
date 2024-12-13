package _1_ThreadAndProcesses;

public class SimpleRunnable implements Runnable{
    private String name;
    public SimpleRunnable(String name){
        this.name = name;
    }

    @Override
    public void run() {
        for (int i = 0; i <= 5; i++) {
            System.out.println(name +": " + i);
            try {
                Thread.sleep(500);
            }   catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
