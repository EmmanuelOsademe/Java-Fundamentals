package enumsPlus.annotation;

@Deprecated
public class MyClass {
    private  String msg;

    public MyClass(String m){
        msg = m;
    }

    // Deprecate a method withing a class
    @Deprecated
    String getMsg(){
        return msg;
    }

}
