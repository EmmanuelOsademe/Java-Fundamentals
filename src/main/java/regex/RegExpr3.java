package regex;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class RegExpr3 {
    public static void main(String[] args){
        Pattern pat = Pattern.compile("test");
        Matcher mat = pat.matcher("test 1 2 3 test");
        int counter = 0;

        try{
            while(mat.find()){
                counter++;
                System.out.println("test found at index " + mat.start() + " and ended at index " + (mat.end() -1));
                System.out.println("Group " + counter + ": " + mat.group());
            }
        }catch(IllegalStateException exp){
            System.out.println("An error occurred");
        }

    }
}
