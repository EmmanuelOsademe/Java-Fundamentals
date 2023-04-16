package generics.gen1;

public class GenDemo {
    public static void main(String[] args){
        // Create a Gen reference for Integers
        Gen<Integer> iObj;

        // Create a Gen<Integer> object and assign its reference to iObj. Notice the use of autoboxing to encapsulate the value
        iObj = new Gen(88);

        iObj.showType();

        int v = iObj.getObj();
        System.out.println("value: " + v);

        // Similarly for Strings
        Gen<String> strObj = new Gen("Generics Test");

        strObj.showType();

        String str = strObj.getObj();
        System.out.println("value: " + str);
    }
}
