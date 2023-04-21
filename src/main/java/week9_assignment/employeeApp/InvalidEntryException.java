package week9_assignment.employeeApp;

public class InvalidEntryException extends Exception{
    @Override
    public String toString() {
        return "Invalid Entry";
    }
}
