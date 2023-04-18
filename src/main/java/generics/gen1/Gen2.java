package generics.gen1;

public class Gen2<T, V> {
    T obj1;
    V obj2;

    public Gen2(T o1, V o2){
        obj1 = o1;
        obj2 = o2;
    }

    public void showTypes(){
        System.out.println("Type of T is: " + obj1.getClass().getName());
        System.out.println("Type of V is: " + obj2.getClass().getName());
    }

    public T getObj1() {
        return obj1;
    }

    public V getObj2() {
        return obj2;
    }

    public static void main(String[] args){
        Gen2<Integer, String> newObj = new Gen2<>(88, "Generics");

        newObj.showTypes();

        System.out.println("value: " + newObj.getObj1());
        System.out.println("value: " + newObj.getObj2());
        System.out.println(newObj.getClass().getName());
    }
}
