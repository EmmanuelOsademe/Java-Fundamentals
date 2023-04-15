package enumsPlus.boxingAndUnboxing;

public class AutoBoxing {
    public static void main(String[] args){

        //Autobox an int
        Integer iOb = 100;
        System.out.println(iOb.getClass());

        // Auto unbox an int
        int i = iOb;
        System.out.println(i + " " + iOb);
    }
}
