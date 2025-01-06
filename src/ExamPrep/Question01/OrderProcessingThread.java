package ExamPrep.Question01;

import java.util.List;
import java.util.Queue;

public class OrderProcessingThread extends Thread {
    Queue<Integer> orderList;

    public OrderProcessingThread(Queue<Integer> orderList,String name) {
        super(name);
        this.orderList = orderList;
    }
    @Override
    public void run() {
        while (!orderList.isEmpty()) {
            int orderNumber;
            try {
                orderNumber = orderList.element();
                System.out.println("Processing Order Number : " + orderNumber);
                Thread.sleep(500);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
