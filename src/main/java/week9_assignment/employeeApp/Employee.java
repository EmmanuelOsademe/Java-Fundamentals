package week9_assignment.employeeApp;

import java.util.Date;

public class Employee {
    String employeeId;
    String employeeName;
    String employeeDepartment;
    String designation;
    Date dateEmployed;
    Date dateOfBirth;
    MaritalStatus maritalStatus;
    Date dateOfMarriage;

    public Employee(String employeeId, String employeeName, String employeeDepartment, String designation,
                    Date dateEmployed, Date dateOfBirth, MaritalStatus maritalStatus){
        this.employeeId = employeeId;
        this.employeeName = employeeName;
        this.employeeDepartment = employeeDepartment;
        this.designation = designation;
        this.dateEmployed = dateEmployed;
        this.dateOfBirth = dateEmployed;
        this.maritalStatus = maritalStatus;
    }

    public Employee(String employeeId, String employeeName, String employeeDepartment, String designation,
                    Date dateEmployed, Date dateOfBirth, MaritalStatus maritalStatus, Date dateOfMarriage){
        this.employeeId = employeeId;
        this.employeeName = employeeName;
        this.employeeDepartment = employeeDepartment;
        this.designation = designation;
        this.dateEmployed = dateEmployed;
        this.dateOfBirth = dateEmployed;
        this.maritalStatus = maritalStatus;
        this.dateOfMarriage = dateOfMarriage;
    }
}
