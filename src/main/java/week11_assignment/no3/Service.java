package week11_assignment.no3;

public class Service implements Runnable{
    int start;
    int end;
    Thread thread;

    public Service (String threadName, int start, int end){
        thread = new Thread(this, threadName);
        this.start = start;
        this.end = end;
    }

    public static Service createAndStart(String threadName, int start, int end){
        Service service = new Service(threadName, start, end);
        service.thread.start();
        return service;
    }
    @Override
    public void run(){
        try{
            print(this.start, this.end);
            Thread.sleep(1000);
        }catch (InterruptedException exc){
            System.out.println("Interrupted");
        }
    }

    public void print(int start, int end){
        for(int i = start; i <= end; i++){
            System.out.println(i);
        }
    }
}
