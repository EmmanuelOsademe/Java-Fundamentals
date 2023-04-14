package multithreading;

public class MyThread1 implements Runnable{
    String threadName;

    public MyThread1(String threadName){
        this.threadName = threadName;
    }

    // Entry point of the thread;
    public void run(){
        System.out.println(threadName + " starting");
        try{
            for(int count = 0; count < 10; count++){
                Thread.sleep(400);
                System.out.println("In " + threadName + ", count is " + count);
            }
        }catch(InterruptedException exc){
            System.out.println(threadName + " interrupted");
        }
        System.out.println(threadName + " terminating.");
    }

    public static void main(String[] args){
        System.out.println("Main thread starting");

        // First, construct a thread object;
        MyThread1 mt = new MyThread1("Child #1");

        // Construct a thread from that object
        Thread newThread = new Thread(mt);
        newThread.start();

        for(int i=0; i < 50; i++){
            try{
                System.out.println("Main thread, count " + i);
                Thread.sleep(100);
            }catch(InterruptedException exp){
                System.out.println("Main thread interrupted");
            }
        }

        System.out.println("Main thread ending");
    }
}
