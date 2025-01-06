package ExamPrep.Question01;

import java.util.Queue;

public class IntentoryUpdateRunnable implements Runnable {
    Queue<Integer> orderList;

    public IntentoryUpdateRunnable(Queue<Integer> orderList) {
        this.orderList = orderList;
    }
    @Override
    public void run() {
        while (!orderList.isEmpty()) {
            int orderNumber;
            try {
                orderNumber = orderList.poll();
                System.out.println("Update inventory remove Order Number : " + orderNumber);
                Thread.sleep(500);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

}
