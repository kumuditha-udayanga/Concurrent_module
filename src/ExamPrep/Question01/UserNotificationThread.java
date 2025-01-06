package ExamPrep.Question01;

import java.util.Queue;

public class UserNotificationThread extends Thread{
    Queue<Integer> orderList;

    public UserNotificationThread(Queue<Integer> orderList) {
        this.orderList = orderList;
    }
    @Override
    public void run() {
        while (!orderList.isEmpty()) {
            int orderNumber;
            try {
                orderNumber = orderList.element();
                System.out.println("Status thread, Order is ready : " + orderNumber);
                Thread.sleep(500);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
