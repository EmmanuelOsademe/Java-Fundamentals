package enumsPlus;

public class EnumDemo2 {
    public static void main(String[] args){
        Transport tp;

        System.out.println("Here are all the Transport constants");

        // Use values()
        Transport[] allTransports = Transport.values();
        for(Transport t: allTransports){
            System.out.println(t);
        }

        System.out.println();

        // Use valueOf()
        tp = Transport.valueOf("TRAIN");
        System.out.println("tp contains: " + tp);

    }
}
