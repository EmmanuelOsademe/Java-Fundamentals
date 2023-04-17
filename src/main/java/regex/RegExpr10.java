package regex;

import java.util.regex.Pattern;

public class RegExpr10 {
    public static void main(String[] args){
        Pattern pat = Pattern.compile("[ ,.!]");

        String[] strs = pat.split("One two,alpha9 12!done.");

        for(String st: strs){
            System.out.println("Next token: " + st);
        }
    }
}
