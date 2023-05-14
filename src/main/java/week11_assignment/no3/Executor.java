package week11_assignment.no3;

import java.sql.SQLOutput;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

public class Executor {
    public static void main(String[] args){
//        int coreCount = Runtime.getRuntime().availableProcessors();
//        System.out.println(coreCount + " cores");
        ExecutorService es = Executors.newFixedThreadPool(2);
        Service threadA = new Service("ThreadA", 1, 10);
        Service threadB = new Service("threadB", 11, 20);
        es.execute(threadA);
        es.execute(threadB);


        es.shutdown();

//        try{
//            es.awaitTermination(10, TimeUnit.SECONDS);
//        }catch(InterruptedException exc){
//            System.out.println("Interrupted");
//        }
//
//        // Synchronous task
//        ExecutorService service = Executors.newCachedThreadPool();
//        for(int i = 0; i < 10; i++){
//            service.execute(new Service(i));
//        }
//
//        // scheduled Executor service
//        ScheduledExecutorService sservice = Executors.newScheduledThreadPool(10);
    }
}
