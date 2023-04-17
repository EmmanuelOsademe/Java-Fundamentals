package regex;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class RegExpr8 {
    public static void main(String[] args){
        Pattern pat = Pattern.compile("[a-z]+");
        Matcher mat = pat.matcher("this is a test A very hard test");

        while(mat.find()){
            System.out.println("Match: "+ mat.group());
        }
    }
}
