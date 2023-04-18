package generics.gen1;

public class Gen3 <T extends Number>{
    T num;

    public Gen3(T n){
        num = n;
    }

    public double reciprocal(){
        return 1 / num.intValue();
    }

    public double fraction(){
        return num.doubleValue() / num.intValue();
    }

    public boolean absEqual(Gen3<?> ob){
        if(Math.abs(num.doubleValue()) == Math.abs(ob.num.doubleValue())){
            return true;
        }
        return false;
    }

    public static void main(String[] args){
        Gen3<Integer> iOb = new Gen3<>(5);

        System.out.println("The reciprocal of iob is: " + iOb.reciprocal());
        System.out.println("The fraction of iob is: " + iOb.fraction());

        Gen3<Double> dOb = new Gen3<>(5.0);

        Gen3<Double> fOb = new Gen3<>(-5.0);

        System.out.println("The reciprocal of dob is: " + dOb.reciprocal());
        System.out.println("The fraction of dob is: " + dOb.fraction());

        System.out.println(dOb.absEqual(fOb));
    }
}
