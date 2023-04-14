package multithreading;

public class MyThread2 implements Runnable{
    Thread thread;

    public MyThread2(String name){
        thread = new Thread(this, name);
    }

    // A factory method that creates and starts a thread.
    public static MyThread2 createAndStart(String threadName){
        MyThread2 newThread = new MyThread2(threadName);
        // Start the new thread;
        newThread.thread.start();
        return newThread;
    }

    public void run(){
        System.out.println(thread.getName() + " starting");
        for(int count = 0; count < 10; count++){
            try{
                Thread.sleep(400);
                System.out.println("In " + thread.getName() + ", count is " + count);
            }catch(InterruptedException exc){
                System.out.println(thread.getName() + " interrupted");
            }
        }
    }

    public static void main(String[] args){
        System.out.println("Main thread starting");

        // Create and start thread;
        MyThread2 mt = MyThread2.createAndStart("Child #1");

        for(int i = 0; i < 50; i++){
            System.out.println(i);
            try{
                Thread.sleep(100);
            }catch(InterruptedException exc){
                System.out.println("Main thread interrupted");
            }
        }
        System.out.println("Main thread ending");
    }
}
