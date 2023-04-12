package week8_assignment_b;

import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Book {
    Scanner sc = new Scanner(System.in);
    String authorName;
    String bookTitle;
    double bookPrice;
    int stock;
    int numberOfPages;

    public Book(String authorName, String bookTitle, double bookPrice, int stock, int numberOfPages){
        this.authorName = authorName;
        this.bookTitle = bookTitle;
        this.bookPrice = bookPrice;
        this.stock = stock;
        this.numberOfPages = numberOfPages;
    }

    public Book(){};

    protected double validateDouble(String inputString){
        Pattern doubleRegex = Pattern.compile("([.]?[0-9]+)|([0-9]*[.][0-9]*)");
        Matcher doubleMatcher = doubleRegex.matcher(inputString);
        if(!doubleMatcher.matches()){
            System.out.print("Invalid number provided.\nPlease enter a valid number: ");
            String newInput = sc.next();
            return validateDouble(newInput);
        }else{
            return Double.parseDouble(inputString);
        }
    }

    protected int validateInt(String inputString){
        Pattern intRegex = Pattern.compile("[0-9]+");
        Matcher intMatcher = intRegex.matcher(inputString);
        if(!intMatcher.matches()){
            System.out.print("Invalid number provided.\nPlease enter a valid number: ");
            String newInput = sc.next();
            return validateInt(newInput);
        }else{
            return Integer.parseInt(inputString);
        }
    }
}
