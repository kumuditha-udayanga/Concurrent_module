package ThreadAndProcesses_1;

public class Main {
    public static void main(String[] args){
//       Thread using Thread Class
        SimpleThread thread1 = new SimpleThread("Thread extending Thread-1");

//      With runnable interface
        SimpleRunnable runnable = new SimpleRunnable("Thread implementing Runnable-2");
        //    Pass the runnable instance to the thread2 object
        Thread thread2= new Thread(runnable);

        thread1.start();
        thread2.start();
    }
}