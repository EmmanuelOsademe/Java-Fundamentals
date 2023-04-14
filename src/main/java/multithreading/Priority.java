package multithreading;

public class Priority implements Runnable{

    int count;
    Thread thread;
    static boolean stop = false;
    static String currentName;

    public Priority(String name){
        thread = new Thread(this, name);
        count = 0;
        currentName = name;
    }

    /*public static Priority createAndStart(String name){
        Priority newThread = new Priority(name);
        newThread.thread.start();
        return newThread;
    }*/

    public void run(){
        System.out.println(thread.getName() + " starting");
        do{
            count ++;

            if(currentName.compareTo(thread.getName()) != 0){
                currentName = thread.getName();
                System.out.println("In " + currentName);
            }
        }while(!stop && count < 10000000);

        stop = true;
        System.out.println("\n" + thread.getName() + " terminating.");
    }

    public static void main(String[] args){

        Priority mt1 = new Priority("High Priority");
        Priority mt2 = new Priority("Low Priority");
        Priority mt3 = new Priority("Normal Priority #1");
        Priority mt4 = new Priority("Normal Priority #2");
        Priority mt5 = new Priority("Normal Priority #3");

        mt1.thread.setPriority(Thread.NORM_PRIORITY + 2);
        mt2.thread.setPriority(Thread.NORM_PRIORITY - 2);

        // The last thread will retain normal priority

        mt1.thread.start();
        mt2.thread.start();
        mt3.thread.start();
        mt4.thread.start();
        mt5.thread.start();

        try{
            mt1.thread.join();
            mt2.thread.join();
            mt3.thread.join();
            mt4.thread.join();
            mt5.thread.join();
        }catch (InterruptedException exc){
            System.out.println("Main thread interrupted");
        }

        System.out.println("\n High priority thread counted to " + mt1.count);
        System.out.println("\n Low priority thread counted to " + mt2.count);
        System.out.println("\n Normal priority #1 thread counted to " + mt3.count);
        System.out.println("\n Normal priority #2 thread counted to " + mt4.count);
        System.out.println("\n Normal priority #3 thread counted to " + mt5.count);
    }
}
