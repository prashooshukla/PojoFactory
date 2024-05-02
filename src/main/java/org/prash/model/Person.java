package org.prash.model;

import java.time.LocalDate;
import java.time.Period;
import java.time.format.DateTimeFormatter;

/**
 * Project: PojoFactory
 * Author: bittu
 */


public class Person {

    private String firstName;
    private String lastName;
    private LocalDate dob; // Date of birth
    private Address address;

    private static final String dateFormat = "dd-MM-yy";

    public Person() {
    }

    public Person(String firstName, String lastName, String dob, Address address) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.address = address;
        setDob(dob);
    }

    public Person(String firstName, String lastName, LocalDate dob, Address address) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.dob = dob;
        this.address = address;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getDob() {
        return dob.toString();
    }

    public String getDob(String format) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern(format);
        return this.dob.format(formatter);
    }

    public void setDob(LocalDate dob) {
        this.dob = dob;
    }

    // Setter for dob accepting string in "dd-MM-yyyy" format
    public void setDob(String dobStr) {
        setDob(dobStr, dateFormat);
    }

    // Setter for dob accepting string in any valid format
    public void setDob(String dobStr, String format) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern(format);
        this.dob = LocalDate.parse(dobStr, formatter);
    }

    public int getAge() {
        return Period.between(this.dob, LocalDate.now()).getYears();
    }

    public String getCompleteAge() {
        Period period = Period.between(this.dob, LocalDate.now());
        return period.getYears() + " years " + period.getMonths() + " months " + period.getDays() + " days";
    }

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

    public String getName() {
        return firstName + " " + lastName;
    }

    @Override
    public String toString() {
        return "Person{" +
                "firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", dob=" + dob +
                ", address=" + address +
                '}';
    }
}
