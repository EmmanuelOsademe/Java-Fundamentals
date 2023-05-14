package week11_assignment.no2;

public class ThreadRunner implements Runnable{

    Thread thread;
    int tableToPrint;

    public ThreadRunner(String threadName, int tableToPrint){
        thread = new Thread(this, threadName);
        this.tableToPrint = tableToPrint;
    }

    public static ThreadRunner createAndStart(String threadName, int tableToPrint){
        ThreadRunner thread2 = new ThreadRunner(threadName, tableToPrint);
        thread2.thread.start();
        return thread2;
    }

    public void run(){
        synchronized (ThreadRunner.class){
            System.out.println("Start print the table for " + thread.getName());
            createTable(tableToPrint);
            System.out.println("Ended printing table for " + thread.getName());
        }
    }

    synchronized public void createTable(int num){
        for(int i = 1; i <= 10; i++){
            System.out.println(num + " x " + i + " = " + (num * i));
        }
    }

    public static void main(String[] args){
        ThreadRunner tableA = createAndStart("Two Times Table", 2);
        ThreadRunner tableB = createAndStart("Four Times Table", 4);

        try{
            tableA.thread.join();
            tableB.thread.join();
        }catch(InterruptedException exc){
            System.out.println("Main thread interrupted");
        }
    }
}
