package week9_assignment;

public class MyInvalidTypeException extends Exception{
    //int num2;
    //public  MyInvalidTypeException(int b){
        //num2 = b;
    //}

    public String toString(){
        return "Division by 0 is not allowed";
    }
}
