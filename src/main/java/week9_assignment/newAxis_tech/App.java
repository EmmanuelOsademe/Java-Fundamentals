package week9_assignment.newAxis_tech;

import java.util.ArrayList;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class App {
    Scanner sc = new Scanner(System.in);
    ArrayList<User> users = new ArrayList<>();

    public static void main(String[] args){
        new App().run();
    }

    public void createUserDetails(){
        System.out.print("Enter your name: ");
        String name = sc.next();

        System.out.print("Enter your age: ");
        int age = validateAge(sc.next());

        System.out.print("Enter your phone number(eg: 8033333333): ");
        String phoneNumber = validatePhoneNumber(sc.next());

        System.out.print("Enter your email address: ");
        String email = validateEmail(sc.next());

        System.out.print("Enter your house address: ");
        sc.nextLine();
        String address = sc.nextLine();
        System.out.println(address);

        users.add(new User(name, age, new ContactDetails(phoneNumber, email, address)));
        System.out.println("Your details have been saved");
    }

    public void getUserDetails(){
        System.out.print("Enter name: ");
        String name = sc.next();
        boolean userFound = false;
        for(User user: users){
            if(user.name.equalsIgnoreCase(name)){
                userFound = true;
                printUserDetails(user);
                break;
            }
        }
        if(!userFound){
            System.out.println("User does not exist");
        }
    }

    public void printUserDetails(User user){
        System.out.println("Name: " + user.name);
        System.out.println("Age: " + user.age);
        System.out.println("Phone number: " + user.contactDetails.phone);
        System.out.println("Email address: " + user.contactDetails.email);
        System.out.println("Address: " + user.contactDetails.address);
    }

    public void run(){
        System.out.print("To create user, enter 1\nTo view user details, enter 2\nTo exit enter 3: ");
        int userEntry = validateRunOptions(sc.next());

        switch(userEntry){
            case 1:
                createUserDetails();
                run();
            case 2:
                getUserDetails();
                run();
            case 3:
                System.exit(0);
        }
    }

    public int validateRunOptions(String input){
        Pattern oneToThreePattern = Pattern.compile("[123]");
        Matcher oneToThreeMatcher = oneToThreePattern.matcher(input);
        if(oneToThreeMatcher.matches()){
            return Integer.parseInt(input);
        }else{
            System.out.println("Invalid entry. Expected 1, 2 or 3");
            System.out.println("Please make another entry: ");
            return validateRunOptions(sc.next());
        }
    }

    public int validateAge(String input){
        Pattern agePattern = Pattern.compile("([2-4][0-9])|5[0-5]");
        Matcher ageMatcher = agePattern.matcher(input);

        try{
            if(!ageMatcher.matches()){
                throw new InvalidAgeException();
            }else{
                return Integer.parseInt(input);
            }
        }catch(InvalidAgeException exc){
            System.out.println(exc);
            System.out.print("Make another entry: ");
            return validateAge(sc.next());
        }
    }

    public String validatePhoneNumber(String input){
        Pattern phonePattern = Pattern.compile("[7-9][0-1][0-9]{8}");
        Matcher phoneMatcher = phonePattern.matcher(input);
        if(phoneMatcher.matches()){
            return input;
        }else{
            System.out.print("Invalid phone number. Try again: ");
            return validatePhoneNumber(sc.next());
        }
    }

    public String validateEmail(String input){
        Pattern emailPattern = Pattern.compile("[A-Za-z0-9_.-]{5,20}@[a-z.]{3,20}");
        Matcher emailMatcher = emailPattern.matcher(input);

        if(!emailMatcher.matches()){
            System.out.print("Invalid email format entered. Please try again (eg: john.doe@abc.com): ");
            return validateEmail(sc.next());
        }

        return input;
    }
}
