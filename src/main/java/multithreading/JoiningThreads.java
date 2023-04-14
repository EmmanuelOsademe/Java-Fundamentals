package multithreading;

public class JoiningThreads implements Runnable{
    Thread thread;

    public JoiningThreads(String threadName){
        thread = new Thread(this, threadName);
    }

    public static JoiningThreads createAndStart(String name){
        JoiningThreads newThread = new JoiningThreads(name);
        newThread.thread.start();
        return newThread;
    }

    public void run(){
        System.out.println("Starting " + thread.getName());
        for(int count = 0; count < 10; count++){
            try{
                System.out.println("In " + thread.getName() + ", count is " + count);
                Thread.sleep(400);
            }catch (InterruptedException exc){
                System.out.println(thread.getName() + " interrupted.");
            }
        }
        System.out.println(thread.getName() + " ending");
    }

    public static void main(String[] args){
        System.out.println("Starting main thread");
        MyThread5 mt1 = MyThread5.createAndStart("Child 1");
        MyThread5 mt2 = MyThread5.createAndStart("Child #2");
        MyThread5 mt3 = MyThread5.createAndStart("Child #3");

        try{
            mt1.thread.join();
            System.out.println(mt1.thread.getName() + " joined");

            mt2.thread.join();
            System.out.println(mt2.thread.getName() + " joined");

            mt3.thread.join();
            System.out.println(mt3.thread.getName() + " joined");
        }catch (InterruptedException exc){
            System.out.println("Main thread interrupted");
        }
        System.out.println("Main thread ending");
    }
}
