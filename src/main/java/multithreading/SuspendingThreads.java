package multithreading;

public class SuspendingThreads implements Runnable{
    Thread thread;
    boolean suspended;
    boolean stopped;

    public SuspendingThreads(String name){
        thread = new Thread(this, name);
        suspended = false;
        stopped = false;
    }

    public static SuspendingThreads createAndStart(String threadName){
        SuspendingThreads newThread = new SuspendingThreads(threadName);
        newThread.thread.start();
        return newThread;
    }

    public void run(){
        System.out.println(thread.getName() + " starting.");

        try{
            for(int i = 1; i < 1000; i++){
                System.out.print(i + " ");
                if((i % 10) == 0){
                    System.out.println();
                    Thread.sleep(250);
                }

                // Use synchronized block to check suspended and stopped.
                synchronized (this){
                    while(suspended){
                        wait();
                    }
                    if(stopped){
                        break;
                    }
                }
            }
        } catch (InterruptedException exc){
            System.out.println(thread.getName() + " interrupted");
        }

        System.out.println(thread.getName() + " exiting");
    }

    // Stop the thread
    synchronized void myStop(){
        stopped = true;

        // The following ensures that a suspended thread can be stopped.
        suspended = false;
        notify();
    }

    // Suspend the thread;
    synchronized void mySuspend(){
        suspended = true;
    }

    synchronized void myResume(){
        suspended = false;
        notify();
    }

    public static void main(String[] args){
        SuspendingThreads mt1 = createAndStart("My Thread");

        try{
            Thread.sleep(1000);

            mt1.mySuspend();
            System.out.println("Suspending thread.");
            Thread.sleep(1000);

            mt1.myResume();
            System.out.println("Resuming thread.");
            Thread.sleep(1000);

            mt1.mySuspend();
            System.out.println("Suspending thread.");
            Thread.sleep(1000);

            mt1.myResume();
            System.out.println("Resuming thread.");
            Thread.sleep(1000);

            mt1.mySuspend();
            System.out.println("Suspending thread.");
            Thread.sleep(1000);
        }catch(InterruptedException exc){
            System.out.println("Main thread interrupted");
        }

        // Wait for thread to finish
        try{
            mt1.thread.join();
        }catch (InterruptedException exc){
            System.out.println("Main thread interrupted");
        }

        System.out.println("Main thread exiting");
    }
}
