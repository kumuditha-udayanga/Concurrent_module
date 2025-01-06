package _8_ReentrantLock.ProducerConsumerWithSync;

import java.util.LinkedList;
import java.util.Queue;

public class Buffer {
    private int maxSize = 4;

    Queue<Integer> list = new LinkedList<>();

    public synchronized void produce (int value) {
        try {
            while (list.size() == maxSize ) {
                System.out.println("Produce method going to waiting state");
                wait();
            }
            list.add(value);
            System.out.println("Producing value:" + value);
            notifyAll();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

    }

    public synchronized void consume () {
        int value;
        try {
            while (list.isEmpty()) {
                System.out.println("Consume method going to waiting state");
                wait();
            }
            value = list.poll();
            System.out.println("Consuming value: " + value);
            notifyAll();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
