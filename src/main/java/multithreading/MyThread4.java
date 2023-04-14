package multithreading;

public class MyThread4 extends Thread{
    public MyThread4(String name){
        super(name);
    }

    public static MyThread4 createAndStart(String threadName){
        MyThread4 myThread = new MyThread4(threadName);
        myThread.start();
        return myThread;
    }

    @Override
    public void run(){
        System.out.println(getName() + " starting");
        try{
            for(int count = 0; count < 10; count++){
                Thread.sleep(400);
                System.out.println("In " + getName() + ", count is " + count);
            }
        }catch (InterruptedException exc){
            System.out.println(getName() + " interrupted");
        }
    }

    public static void main(String[] args){
        System.out.println("Main thread is starting.");
        MyThread4 mt = MyThread4.createAndStart("Child #4");

        for(int i = 0; i < 50; i++){
            System.out.println(i);
            try{
                Thread.sleep(100);
            }catch(InterruptedException exc){
                System.out.println("Main thread interrupted");
            }
        }
        System.out.println("Main thread ending");
    }
}
