package week11_assignment.no1;

public class ThreadRunner implements Runnable{
    Thread thread;

    public ThreadRunner(String threadName) {
        this.thread = new Thread(this, threadName);
    }

    public static ThreadRunner createAndStartThread(String threadName){
        ThreadRunner thread1 = new ThreadRunner(threadName);
        thread1.thread.start();
        return thread1;
    }

    public void run(){
        synchronized (ThreadRunner.class){
            System.out.println(thread.getName() + " Starts");

            for(int i = 1; i <= 10; i++){
                System.out.printf("%s in the loop, i = %s\n", thread.getName(), i);
            }
            System.out.println(thread.getName() + " exits");
            System.out.println(thread.getName() + " sleeping for 5 seconds");
        }
    }

    public static void main(String[] args){
        System.out.println("Starting the main thread");
        ThreadRunner threadA = ThreadRunner.createAndStartThread("ThreadA");
        ThreadRunner threadB = ThreadRunner.createAndStartThread("ThreadB");

        do{
            try{
                threadA.thread.join();
                threadB.thread.join();
            }catch (InterruptedException exc){
                System.out.println("Main thread interrupted");
            }
        }while(threadA.thread.isAlive() || threadB.thread.isAlive());

        System.out.println("Ending main thread");

//        ThreadRunner threadA = ThreadRunner.createAndStartThread("ThreadA");
//        try {
//            threadA.thread.join();
//        } catch (InterruptedException e) {
//            throw new RuntimeException(e);
//        }
//        ThreadRunner threadB = ThreadRunner.createAndStartThread("ThreadB");
//        try {
//            threadB.thread.join();
//        } catch (InterruptedException e) {
//            throw new RuntimeException(e);
//        }
    }
}
