package multithreading;

public class DemoSync2 implements Runnable {
    Thread thread;
    static SumArray2 sa = new SumArray2();
    int[] a;
    int answer;

    public DemoSync2(String name, int[] nums){
        thread = new Thread(this, name);
        a = nums;
    }

    public static DemoSync2 createAndStart(String threadName, int[] nums){
        DemoSync2 newThread = new DemoSync2(threadName, nums);
        newThread.thread.start();
        return newThread;
    }

    public void run(){
        System.out.println(thread.getName() + " starting");

        // Synchronized calls to sumArray();
        synchronized (sa){
            answer = sa.sumArray(a);
        }

        System.out.println("Sum for " + thread.getName() + " is " + answer);

        System.out.println(thread.getName() + " terminating");
    }

    public static void main(String[] args){
        int[] a = {1, 2, 3, 4, 5};

        DemoSync2 mt1 = createAndStart("Child #1", a);
        DemoSync2 mt2 = createAndStart("Child #2", a);

        try{
            mt1.thread.join();
            mt2.thread.join();
        } catch (InterruptedException exc){
            System.out.println("Main thread interrupted");
        }
    }
}

class SumArray2 {
    private int sum;

    int sumArray(int[] nums){
        sum = 0;

        for(int num: nums){
            sum += num;
            System.out.println("Running sum for " + Thread.currentThread().getName() + " is " + sum);
            try{
                Thread.sleep(500);
            }catch(InterruptedException exc){
                System.out.println(Thread.currentThread().getName() + " interrupted.");
            }
        }
        return sum;
    }
}
