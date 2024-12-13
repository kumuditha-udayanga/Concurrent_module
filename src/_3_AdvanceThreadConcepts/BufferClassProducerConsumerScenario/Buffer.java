package _3_AdvanceThreadConcepts.BufferClassProducerConsumerScenario;

import java.util.LinkedList;
import java.util.Queue;

public class Buffer {
    private Queue<Integer> list = new LinkedList<>();
    private int maxSize = 5;

    public synchronized void produce(int value) throws InterruptedException {
        while (list.size() == maxSize) {
            wait();
        }
        list.add(value);
        System.out.println("Produced: " + value);
        notifyAll();
    }

    public synchronized int consume() throws InterruptedException {
        while (list.isEmpty()){
            wait();
        }
        int value = list.poll();
        System.out.println("Consumed: "+ value);
        notifyAll();
        return value;
    }
}
