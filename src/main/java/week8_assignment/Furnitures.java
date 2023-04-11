package week8_assignment;

import java.util.ArrayList;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Furnitures implements Furniture{
    static Scanner sc = new Scanner(System.in);
    ArrayList<Order> orders = new ArrayList<>();
    public void acceptOrder(){
        System.out.println("Enter the following details to complete your order");

        System.out.print("Enter your name: ");
        String customer = sc.next();

        System.out.print("Enter your Order Type (Chair or Bookshelf): ");
        String userChoice = sc.next();
        FurnitureTypes furnitureType = validateFurnitureType(userChoice);

        System.out.print("Enter price for the order: ");
        double price = validateDouble(sc.next());

        System.out.print("Enter the width of the furniture (ft): ");
        double width = validateDouble(sc.next());

        System.out.print("Enter the height of the furniture (ft): ");
        double height = validateDouble(sc.next());

        String orderID = generateRandomID();

        Order newOrder = new Order(furnitureType, orderID, customer, price, width, height);

        orders.add(newOrder);

        System.out.println("Your order has been received. Your OrderID is: " + orderID);
    }

    public void displayOrder(){
        System.out.print("To view single order, enter 1. To view all your orders, enter 2: ");

        String userChoice = sc.next();
        int displayOption = validateOrderDisplayOption(userChoice);

        if(displayOption == 1){
            displaySingleOrder();
        }else{
            displayAllUserOrders();
        }
    }

    public void run(){
        //System.out.println("Hello and welcome to Furniture and Fittings Company\nWe manufacture and deliver quality " +
                //"chairs and bookshelves");
        System.out.print("To place an order, enter 1. To view an order, enter 2. To exit, press 3: ");

        String userChoice = sc.next();
        int option = validatePreferredAction(userChoice);

        if(option ==  1){
            acceptOrder();
            run();
        }else if(option == 2){
            displayOrder();
            run();
        }else{
            System.exit(0);
        }
    }

    public static void main(String[] args){
        Furnitures f = new Furnitures();
        f.run();
    }

    public FurnitureTypes validateFurnitureType(String furnitureType){
        if(furnitureType.equalsIgnoreCase("chair")){
            return FurnitureTypes.CHAIR;
        } else if (furnitureType.equalsIgnoreCase("bookshelf")) {
            return  FurnitureTypes.BOOKSHELF;
        }else {
            System.out.print("Invalid entry.\nEnter a valid furniture type (Chair or Bookshelf): ");
            return validateFurnitureType(sc.next());
        }
    }

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

    public String generateRandomID (){
        String alphaNumericStrings = "ABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789abcdefghijklmnopqrstuvwxyz";

        StringBuilder str = new StringBuilder(12);

        for(int i = 0; i < 12; i++){
            int pos = (int)(alphaNumericStrings.length() * Math.random());
            str.append(alphaNumericStrings.charAt(pos));
        }

        return str.toString();
    }

    public void displaySingleOrder(){
        System.out.print("Enter your name: ");
        String name = sc.next();

        System.out.print("Enter the order ID: ");
        String orderID = sc.next();
        boolean orderFound = false;

        for(Order order: orders){
            if(order.customer.equalsIgnoreCase(name) && order.orderID.equalsIgnoreCase(orderID)){
                orderFound = true;
                System.out.println("Here are the details of your order:");
                System.out.printf("Furniture type: %s \n", order.furniture);
                System.out.printf("Furniture Price: %6.2f \n", order.price);
                System.out.printf("Furniture Dimension (width x Height): %6.2f ft by %6.2f ft \n\n", order.width, order.height);
                break;
            }
        }

        if(!orderFound){
            System.out.printf("Order with ID: %s does not exist. Please check your Order ID and try again", orderID);
        }
    }

    public void displayAllUserOrders(){
        System.out.print("Enter your name: ");
        String name = sc.next();

        int counter = 0;

        for(Order order: orders){
            if(order.customer.equalsIgnoreCase(name)){
                counter += 1;
                System.out.println("Order no. " + counter);
                System.out.printf("Order ID: %s \n", order.orderID);
                System.out.printf("Furniture type: %s\n", order.furniture);
                System.out.printf("Furniture Price: %6.2f\n", order.price);
                System.out.printf("Furniture Dimension (width x Height): %6.2f ft by %6.2f ft\n\n", order.width, order.height);
            }
        }

        if(counter == 0){
            System.out.println("You do not have any order(s) at the moment");
        }
    }

    protected int validateOrderDisplayOption(String inputString){
        Pattern intRegex = Pattern.compile("[12]");
        Matcher intMatcher = intRegex.matcher(inputString);
        if(!intMatcher.matches()){
            System.out.print("Invalid number provided.\nPlease enter 1 or 2: ");
            String newInput = sc.next();
            return validateOrderDisplayOption(newInput);
        }else{
            return Integer.parseInt(inputString);
        }
    }

    protected int validatePreferredAction(String inputString){
        Pattern intRegex = Pattern.compile("[123]");
        Matcher intMatcher = intRegex.matcher(inputString);
        if(!intMatcher.matches()){
            System.out.print("Invalid number provided.\nPlease enter 1 or 2: ");
            String newInput = sc.next();
            return validatePreferredAction(newInput);
        }else{
            return Integer.parseInt(inputString);
        }
    }
}
