package multithreading;

public class NotifyThread implements  Runnable{
    Thread thread;
    TickTock tickTock;

    public NotifyThread(String name, TickTock tt){
        thread = new Thread(this, name);
        tickTock = tt;
    }

    public static NotifyThread createAndStart(String threadName, TickTock ttObject){
        NotifyThread newThread = new NotifyThread(threadName, ttObject);
        newThread.thread.start();
        return newThread;
    }

    public void run(){
        if(thread.getName().compareTo("Tick") == 0){
            for(int i =0; i < 5; i++){
                tickTock.tick(true);
            }
            tickTock.tick(false);
        }else{
            for(int i = 0; i < 5; i++){
                tickTock.tock(true);
            }
            tickTock.tock(false);
        }
    }

    public static void main(String[] args){
        TickTock ticktock = new TickTock();
        NotifyThread mt1 = NotifyThread.createAndStart("Tick", ticktock);
        NotifyThread mt2 = NotifyThread.createAndStart("Tock", ticktock);

        try{
            mt1.thread.join();
            mt2.thread.join();
        }catch (InterruptedException exc){
            System.out.println("Main thread interrupted");
        }
    }
}

class TickTock {
    String state;

    synchronized void tick(boolean running){
        if(!running){
            state = "ticked";
            notify();
            return;
        }

        System.out.print("Tick ");
        state = "ticked";
        notify();

        try{
            while(!state.equals("tocked")){
                wait(); // Wait foe tock(); to complete
            }
        }catch(InterruptedException exc){
            System.out.println("Thread interrupted");
        }

    }

    synchronized void tock(boolean running){
        if(!running){
            // Stop the clock
            state = "tocked";
            notify(); // notify any waiting threads;
            return;
        }

        System.out.println("Tock");

        state = "tocked";
        notify();
        try{
            while(!state.equals("ticked")){
                wait(); // wait for tick to complete
            }
        }catch(InterruptedException exc){
            System.out.println("Thread interrupted");
        }
    }
}
