package enumsPlus.trafficLight;

public class TrafficLightSimulator implements Runnable{
    private TrafficLightColor tlc;
    private boolean stop = false;
    private boolean changed = false;

    public TrafficLightSimulator(TrafficLightColor init){
        tlc = init;
    }

    public TrafficLightSimulator(){
        tlc = TrafficLightColor.RED;
    }

    public void run(){
        while(!stop){
            try{
                switch (tlc){
                    case GREEN:
                        Thread.sleep(10000);
                        break;
                    case YELLOW:
                        Thread.sleep(2000);
                        break;
                    case RED:
                        Thread.sleep(12000);
                        break;
                }
            }catch(InterruptedException exc){
                System.out.println(Thread.currentThread().getName() + " Interrupted");
            }

            changeColor();
        }
    }

    public synchronized void changeColor(){
        switch (tlc){
            case RED:
                tlc = TrafficLightColor.GREEN;
                break;
            case YELLOW:
                tlc = TrafficLightColor.RED;
                break;
            case GREEN:
                tlc = TrafficLightColor.YELLOW;
                break;
        }
        changed = true;
        notify();
    }

    public synchronized void waitForChange(){
        try{
            while(!changed){
                wait();
                changed = false;
            }
        }catch (InterruptedException exc){
            System.out.println(Thread.currentThread().getName() + " interrupted");
        }
    }

    public synchronized TrafficLightColor getColor(){
        return tlc;
    }

    public synchronized void cancel(){
        stop = true;
    }

    public static void main(String[] args){
        TrafficLightSimulator trafficLight = new TrafficLightSimulator(TrafficLightColor.GREEN);

        Thread thread = new Thread(trafficLight);
        thread.start();

        for(int i =0; i < 9; i++){
            System.out.println(trafficLight.getColor());
            trafficLight.waitForChange();
        }
        trafficLight.cancel();
    }
}
