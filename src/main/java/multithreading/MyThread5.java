package multithreading;

public class MyThread5 implements Runnable{
    Thread thread;

    public  MyThread5(String threadName){
        thread = new Thread(this, threadName);
    }

    public static MyThread5 createAndStart(String name){
        MyThread5 newThread = new MyThread5(name);
        newThread.thread.start();
        return newThread;
    }

    public void run(){
        System.out.println(thread.getName() + " starting");
        try{
            for(int count = 0; count < 10; count++){
                System.out.println("In " + thread.getName() + ", count is " + count);
                Thread.sleep(400);
            }
        }catch (InterruptedException exc){
            System.out.println(thread.getName() + " has been interrupted");
        }
    }

    public static void main(String[] args){
        System.out.println("Main thread starting");
        MyThread5 mt1 = MyThread5.createAndStart("Child #1");
        MyThread5 mt2 = MyThread5.createAndStart("Child #2");
        MyThread5 mt3 = MyThread5.createAndStart("Child #3");

        do{
            System.out.println("Still running Main thread");
            try{
                Thread.sleep(100);
            } catch (InterruptedException exc){
                System.out.println("Main thread interrupted");
            }
        }while(mt1.thread.isAlive() || mt2.thread.isAlive() || mt3.thread.isAlive());
        System.out.println("Main thread is ending");
    }
}
