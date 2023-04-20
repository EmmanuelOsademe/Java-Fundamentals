package week9_assignment.newAxis_tech;

public class InvalidAgeException extends Exception{

    public String toString(){
        return "Age must be between 20 and 55 years";
    }
}
