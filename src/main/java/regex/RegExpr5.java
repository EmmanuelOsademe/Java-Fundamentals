package regex;
import java.util.regex.*;
public class RegExpr5 {
    public static void main(String[] args){
        Pattern pat = Pattern.compile("e.*d");
        Matcher mat = pat.matcher("extend cup end table");

        try {
            while(mat.find()){
                System.out.println("Match: " + mat.group());
            }
        }catch(IllegalStateException exc){
            System.out.println("Illegal state exception");
        }
    }
}
