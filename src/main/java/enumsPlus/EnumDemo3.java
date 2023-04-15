package enumsPlus;

public class EnumDemo3 {

    public static void main (String[] args){
        Transport2 tp;

        // Display all transport types, their speed and their terrain;
        for(Transport2 transport2: Transport2.values()){
            if(transport2.equals(Transport2.TRAIN)){
                transport2.setSpeed(80);
            }
            System.out.printf("Typical speed for %s is %s miles per hour, and it travels on %s\n", transport2, transport2.getSpeed(), transport2.getTerrain());
        }
    }
}
