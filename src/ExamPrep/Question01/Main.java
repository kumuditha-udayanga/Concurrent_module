package ExamPrep.Question01;

import java.util.LinkedList;
import java.util.Queue;

public class Main {
    public static void main(String[] args) {
        Queue<Integer> orderList = new LinkedList<>();

        OrderProcessingThread orderThread = new OrderProcessingThread(orderList, "Order Thread");
        Thread inventoryUpdate = new Thread(new IntentoryUpdateRunnable(orderList));
        UserNotificationThread notify = new UserNotificationThread(orderList);

        orderList.add(1);
        orderList.add(2);
        orderList.add(3);

        orderThread.start();
        notify.start();
        inventoryUpdate.start();
    }

}
