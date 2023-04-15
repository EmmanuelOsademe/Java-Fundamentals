package enumsPlus.boxingAndUnboxing;

public class AutoBox3 {
    public static void main(String[] args){
        Integer iOb;
        Integer iOb2;

        iOb = 99;
        System.out.println("Original value of iOb is: " + iOb);

        // The following automatically unboxes iOb, performs the increment and the reboxes the result back into iOb
        ++iOb;

        System.out.println("After ++iOb, the value is now: " + iOb);

        // Here, iOb is unboxed, the expression is evaluated, and the result is reboxed and stored back in iob;
        iOb += 10;
        System.out.println("After iOb += 10: we have " + iOb);

        // Here, iOb is unboxed, the expression is evaluated and the result is reboxed and assigned to iOb2
        iOb2 = iOb + (iOb/3);
        System.out.println("iOb2 after expression is: " + iOb2);

        // The same expression is evaluated but the result is not reboxed;
        int i = iOb + (iOb /3);
        System.out.println("i after the expression is: " + i);
    }
}
