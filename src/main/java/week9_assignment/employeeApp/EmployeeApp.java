package week9_assignment.employeeApp;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class EmployeeApp {
    ArrayList<Employee> employees = new ArrayList<>();

    Scanner sc = new Scanner(System.in);
    SimpleDateFormat formatter = new SimpleDateFormat("dd-MM-yyyy");

    public static void main(String[] args){
        new EmployeeApp().run();
    }

    private void enterDetails() {
        try{
            System.out.println("Please enter your details to continue");
            System.out.print("Please enter your preferred ID: ");
            String employeeId = validateID(sc.next());

            System.out.print("Please enter your name: ");
            String employeeName = sc.next();

            System.out.print("Please enter your department: ");
            String employeeDepartment = sc.next();

            System.out.print("Please enter your designation: ");
            String designation = sc.next();

            System.out.println("Please enter your employment date (DD-MM-YEAR): ");
            String doeInput = sc.next();
            matchDate(doeInput);
            Date dateEmployed = formatter.parse(doeInput);

            System.out.println("Please enter your date of birth (DD-MM-YEAR): ");
            String dobInput = sc.next();
            matchDate(dobInput);
            Date dateOfBirth = formatter.parse(dobInput);

            System.out.print("Please enter your marital status (Single or Married): ");
            String userInput = sc.next();
            MaritalStatus maritalStatus = getMaritalStatus(userInput);

            if(maritalStatus.equals(MaritalStatus.MARRIED)){
                System.out.println("Please enter your date of marriage (DD-MM-YEAR): ");
                String domInput = sc.next();
                matchDate(domInput);
                Date dateOfMarriage = formatter.parse(domInput);
                Employee newEmployee = new Employee(employeeId, employeeName, employeeDepartment, designation,
                        dateEmployed, dateOfBirth, maritalStatus, dateOfMarriage);
                employees.add(newEmployee);
            }else{
                Employee newEmployee = new Employee(employeeId, employeeName, employeeDepartment, designation,
                        dateEmployed, dateOfBirth, maritalStatus);
                employees.add(newEmployee);
            }

            System.out.println("Thank you for entering your details\nYour details have been saved");
        }catch (ParseException e){
            System.out.println("Error Parsing Data");
        }
    }

    private void viewDetails(){
        try {
            System.out.print("Please enter your ID: ");
            String userInput = sc.next();

            boolean employeeFound = false;

            for(Employee employee: employees){
                if(employee.employeeId.equalsIgnoreCase(userInput)) {
                    employeeFound = true;
                    System.out.printf("Employee Name: %s \n", employee.employeeName);
                    System.out.printf("Employee Designation: %s \n", employee.designation);
                    System.out.printf("Employee Department: %s \n", employee.employeeDepartment);
                    System.out.printf("Employment Date: %s \n", employee.dateEmployed);
                    System.out.printf("Date of Birth: %s \n", employee.dateOfBirth);
                    System.out.printf("Employee marital status: %s \n", employee.maritalStatus);
                    if (employee.maritalStatus.equals(MaritalStatus.MARRIED)) {
                        System.out.printf("Date Married: %s \n", employee.dateOfMarriage);
                    }
                    break;
                }
            }

            if(!employeeFound){
                System.out.printf("Employee with ID: \"%s\" does not exist\n", userInput);
            }

        }catch (NullPointerException e){
            System.out.println("No user has been created");
            System.out.println("You must create a user before visualising user details");
            run();
        }
    }

    private void exit(){
        System.exit(0);
    }

    public void run(){
        boolean keepRunning = true;
        while(keepRunning){
            System.out.println("To register new user, Enter: 1");
            System.out.println("To view user information, Enter: 2");
            System.out.println("To exit, Enter: 3");
            System.out.print(">> ");
            int userChoice = validateMenuEntry(sc.next());
            switch (userChoice){
                case 1:
                    enterDetails();
                    break;
                case 2:
                    viewDetails();
                    break;
                case 3:
                    System.out.println("GoodBye");
                    exit();
            }
        }
    }

    private int validateMenuEntry(String input){
        Pattern menuEntryPattern = Pattern.compile("[1-3]");
        Matcher menuEntryMatcher = menuEntryPattern.matcher(input);
        try{
            if(!menuEntryMatcher.matches()){
                throw new InvalidEntryException();
            }else{
                return Integer.parseInt(input);
            }
        }catch (InvalidEntryException exc){
            System.out.println(exc);
            System.out.print("Please enter 1, 2 or 3: ");
            return validateMenuEntry(sc.next());
        }
    }

    private String validateEmployeeID(String input){
        Pattern employeeIDPattern = Pattern.compile("[^e][a-zA-Z0-9@#%&*$]+");
        Matcher employeeIDMatcher = employeeIDPattern.matcher(input);
        try{
            if(!employeeIDMatcher.matches()){
                throw new InvalidEntryException();
            }else{
                return input;
            }
        }catch (InvalidEntryException exc){
            System.out.println(exc);
            System.out.println("Employee ID must not start with e\nEnter another value: ");
            return validateEmployeeID(sc.next());
        }
    }

    private String validateID(String ID){
        String validatedID = validateEmployeeID(ID);

        for(Employee employee: employees){
            if(employee.employeeId.equalsIgnoreCase(validatedID)){
                System.out.println("ID already exists. \nEnter another value");
                String newID = sc.next();
                validateID(newID);
            }
        }
        return ID;
    }

    private MaritalStatus getMaritalStatus(String maritalStatus){
        if(maritalStatus.equalsIgnoreCase("single")){
            return MaritalStatus.SINGLE;
        } else if (maritalStatus.equalsIgnoreCase("married")) {
            return  MaritalStatus.MARRIED;
        }else {
            System.out.print("Invalid entry.\nEnter your maritalStatus(Single or Married): ");
            return getMaritalStatus(sc.next());
        }
    }

    private void matchDate(String inputDate){
        Pattern dateRegex = Pattern.compile("(0?[1-9]|[12][0-9]|3[01])-(0?[1-9]|1[012])-([0-9]{4})");
        Matcher dateMatcher = dateRegex.matcher(inputDate);
        if(!dateMatcher.matches()){
            System.out.println("Invalid Date Format entered.");
            System.out.println("Please try again! Expected format is DD-MM-YEAR");
            String newInput = sc.next();
            matchDate(newInput);
        }
    }
}
