package _3_AdvanceThreadConcepts.ThreadPoolExecutor;

public class ThreadPoolTest {
    public static void main(String[] args) {
        CustomThreadPool threadPool = new CustomThreadPool(3);

        for (int i = 1; i <= 10; i++) {
            int taskNo = i;
            threadPool.execute(()->{
                System.out.println("Task "+ taskNo + " is running.");
                try {
                    Thread.sleep(500);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println("Task "+taskNo+" completed.");
            });

        }
    }
}
