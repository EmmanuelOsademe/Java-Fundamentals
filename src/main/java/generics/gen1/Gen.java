package generics.gen1;

/*
    A simple generic class. Here, T is a type parameter that will be replaced by a real type when an object of Type Gen is created.
 */
public class Gen <T> {
    T obj; // Declares an object of type T.

    // Constructor
    public Gen(T ob){
        obj = ob;
    }

    public T getObj(){
        return obj;
    }

    // Show type of T
    void showType(){
        System.out.println("Type of T is " + obj.getClass().getName());
    }

}
