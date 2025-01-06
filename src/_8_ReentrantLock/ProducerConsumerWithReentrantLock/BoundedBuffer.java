package _8_ReentrantLock.ProducerConsumerWithReentrantLock;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

public class BoundedBuffer {
    private final ReentrantLock lock = new ReentrantLock();
    private final Condition notFull = lock.newCondition();

    private final Condition notEmpty = lock.newCondition();
    private final Object[] items;
    private int putPtr, takePtr, count;

    public BoundedBuffer (int size) {
        items = new Object[size];
    }

    public void put(Object x) throws InterruptedException{
        lock.lock();
        try {
            while (count == items.length) {
                System.out.println(Thread.currentThread().getName() + " waiting: Buffer is full");
                notFull.await();
            }
            items[putPtr] = x;
            if(++putPtr == items.length) putPtr = 0;
            ++count;
            System.out.println(Thread.currentThread().getName() + " put: " + x);
            notEmpty.signal();
        } finally {
            lock.unlock();
        }
    }

    public Object take() throws InterruptedException {
        lock.lock();
        try {
            while (count == 0) {
                System.out.println(Thread.currentThread().getName() + " waiting: Buffer is empty");
                notEmpty.await();
            }

            Object x = items[takePtr];
            if(++takePtr == items.length) takePtr = 0;
            --count;
            System.out.println(Thread.currentThread().getName()+ " took: " + x);
            notFull.signal();
            return x;
        } finally {
            lock.unlock();
        }
    }
}
