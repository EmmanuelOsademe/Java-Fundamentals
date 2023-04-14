package multithreading;

public class DemoSync implements Runnable{
    Thread thread;
    static SumArray sa = new SumArray();
    int[] a;
    int answer;

    public DemoSync(String name, int[] nums){
        thread = new Thread(this, name);
        a = nums;
    }

    // A factory method that creates and runs a thread;
    public static DemoSync createAndStart (String threadName, int[] nums){
        DemoSync newDemoSync = new DemoSync(threadName, nums);
        newDemoSync.thread.start();
        return newDemoSync;
    }

    public void run(){
        System.out.println(thread.getName() + " starting");

        answer = sa.sumArray(a);
        System.out.println("Sum for " + thread.getName() + " is " + answer);
        System.out.println(thread.getName() + " terminating");
    }

    public static void main (String[] args){
        int[] a = {1, 2, 3, 4, 5};

        DemoSync mt1 = createAndStart("Child #1", a);
        DemoSync mt2 = createAndStart("Child #2", a);

        try{
            mt1.thread.join();
            mt2.thread.join();
        } catch (InterruptedException exc){
            System.out.println("Main thread interrupted");
        }
    }
}

class SumArray {
    private int sum;

    synchronized int sumArray(int[] nums){
        sum = 0;
        for(int num: nums){
            sum += num;
            System.out.println("Running total for " + Thread.currentThread().getName() + " is " +sum);

            try{
                // Allow task-switch
                Thread.sleep(100);
            }catch(InterruptedException exc){
                System.out.println(Thread.currentThread().getName() + " interrupted");
            }
        }
        return sum;
    }
}
