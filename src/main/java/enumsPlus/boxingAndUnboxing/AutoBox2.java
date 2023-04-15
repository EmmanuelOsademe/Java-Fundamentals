package enumsPlus.boxingAndUnboxing;

public class AutoBox2 {
    // This method has an Integer parameter
    static void test(Integer v){
        System.out.println("test() received " + v);
    }

    static int test2(){
        return 10;
    }

    static Integer test3(){
        return 99; // autoboxing 99 into an Integer
    }

    public static void main(String[] args){
        test(199); // 199 (int) is autoboxed into an Integer;

        Integer iOb = test2(); //The return value of test2 is autoboxed into an Integer
        System.out.println("Return value from test2() is " + iOb);

        int i = test3(); // The return value of test3 is unboxed into an int
        System.out.println("Return value from test3() is " + i);

        iOb = 100;
        System.out.println("Square root of " + iOb + " is " + Math.sqrt(iOb));
    }
}
