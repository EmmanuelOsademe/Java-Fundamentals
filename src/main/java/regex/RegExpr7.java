package regex;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class RegExpr7 {
    public static void main(String[] args){
        Pattern pat = Pattern.compile("e.?+d");
        Matcher mat = pat.matcher("extend edcup end table");

        try {
            while(mat.find()){
                System.out.println("Match: " + mat.group());
            }
        }catch(IllegalStateException exc){
            System.out.println("Illegal state exception");
        }
    }
}
