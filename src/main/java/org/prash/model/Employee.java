package org.prash.model;

/**
 * Project: PojoFactory
 * Author: bittu
 */

public class Employee extends Person {

    private String employeeId;
    private String department;
    private Double salary;
    private boolean active;

    public Employee() {
    }

    public Employee(String employeeId, String department, double salary) {
        this.employeeId = employeeId;
        this.department = department;
        this.salary = salary;
        this.active = true;
    }

    public Employee(String employeeId, String department, double salary, Person person) {
        super(person.getFirstName(), person.getLastName(), person.getDob(), person.getAddress());
        this.employeeId = employeeId;
        this.department = department;
        this.salary = salary;
        this.active = true;
    }

    public Employee(String firstName, String lastName, String dob, Address address, String employeeId, String department, double salary) {
        super(firstName, lastName, dob, address);
        this.employeeId = employeeId;
        this.department = department;
        this.salary = salary;
        this.active = true;
    }

    public String getEmployeeId() {
        return employeeId;
    }

    public void setEmployeeId(String employeeId) {
        this.employeeId = employeeId;
    }

    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

    public Double getSalary() {
        return salary;
    }

    public void setSalary(Double salary) {
        this.salary = salary;
    }

    public boolean isActive() {
        return active;
    }

    public void setActive(boolean active) {
        this.active = active;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "employeeId='" + employeeId + '\'' +
                ", department='" + department + '\'' +
                "firstName='" + getFirstName() + '\'' +
                ", lastName='" + getLastName() + '\'' +
                ", salary=" + salary +
                ", active=" + active +
                ", dob=" + getDob() +
                ", address=" + getAddress() +
                '}';
    }
}
