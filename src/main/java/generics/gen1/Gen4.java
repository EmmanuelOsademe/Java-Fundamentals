package generics.gen1;

public class Gen4 <T, V extends T>{
    T first;
    V second;

    public Gen4(T a, V b){
        first = a;
        second = b;
    }

    public static void main(String[] args){
        Gen4<Integer, Integer> x = new Gen4<>(1, 2);
        Gen4<Number, Integer> y = new Gen4<>(10.4, 8);

        Gen4<Number, Double> z = new Gen4<>(10.2, 12.2);
    }
}
