package enumsPlus;

public class EnumDemo1 {

    public static void main(String[] args){
        Transport tp;

        tp = Transport.AIRPLANE;

        // Output an enum value;
        System.out.println("Value of tp: " + tp);
        System.out.println();

        tp = Transport.TRAIN;

        // Compare two enum values;
        if(tp == Transport.TRAIN){
            System.out.println("tp contains Train.\n");
        }

        // Using Enum to control switch statements
        switch (tp){
            case CAR:
                System.out.println("A car carried people");
                break;
            case TRUCK:
                System.out.println("A truck carried freight");
                break;
            case AIRPLANE:
                System.out.println("An airplane flies");
                break;
            case TRAIN:
                System.out.println("A train runs on rails");
                break;
            case BOAT:
                System.out.println("A boat sails on water.");
        }
    }
}
