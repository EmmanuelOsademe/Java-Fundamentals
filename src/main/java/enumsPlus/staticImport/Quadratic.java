package enumsPlus.staticImport;
import static java.lang.Math.*;

public class Quadratic {

    public static void solveQuadratic(double a, double b, double c){
        double d = pow(b, 2) - 4 * a * c;

        // First solution
        double x1 = (- b + sqrt(d))/(2 * a * c);

        // Second solution
        double x2 = (-b - sqrt(d))/(2 * a * c);

        System.out.println("First solution is: " + x1 + ".\nSecond solution is: " + x2);
    }

    public static void main(String[] args){
        solveQuadratic(4, 1, -3);
    }
}
