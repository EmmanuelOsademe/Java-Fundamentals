package multithreading;

public class MyThread3 extends Thread{

    public MyThread3(String name){
        super(name);
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
        MyThread3 mt = new MyThread3("Child #1");
        mt.start();

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
