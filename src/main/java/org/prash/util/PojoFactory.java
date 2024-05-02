package org.prash.util;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.prash.model.Address;
import org.prash.model.AddressList;
import org.prash.model.Employee;
import org.prash.model.Person;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * Project: PojoFactory
 * Author: bittu
 * Date: 02-05-2024
 */

public class PojoFactory {

    private static AddressList cityList = null;
    private static final DataFactory df = new DataFactory();

    private static final String[] IT_DEPARTMENT = {
            "Software Development",
            "Quality Assurance (QA)",
            "DevOps",
            "Project Management",
            "Product Management",
            "User Experience (UX) Design",
            "Information Technology (IT) Support",
            "Network Engineering",
            "Database Administration",
            "Cybersecurity",
            "Data Science",
            "Technical Writing",
            "IT Operations",
            "Cloud Computing",
            "Business Intelligence (BI)",
            "Enterprise Architecture",
            "Research and Development (R&D)",
            "Infrastructure Management",
            "IT Compliance",
            "IT Procurement",
            "Vendor Management"
    };

    public PojoFactory() {


        try (var inputStream = this.getClass().getResourceAsStream("/data.json")) {
            ObjectMapper mapper = new ObjectMapper();
            cityList = mapper.readValue(inputStream, AddressList.class);

//            cityList = mapper.readValue(Path.of("src/main/resources/data.json").toFile(), AddressList.class);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    /**
     * @return A random address
     */
    public Address getAddress() {
        Address address = df.getItem(cityList.getAddresses());
        address.setStreetName(df.getStreetName());
        return address;
    }

    /**
     * <b>Description: Method return a list of Address. Returns empty list if N <= 0</b>
     *
     * @param N (number) of addresses required
     * @return list
     */
    public List<Address> getAddress(int N) {
        List<Address> addresses = new ArrayList<>();
        for (int i = 0; i < N; ++i) {
            addresses.add(getAddress());
        }
        return addresses;
    }

    /**
     * @return A random person
     */
    public Person getPerson() {
        return new Person(
                df.getFirstName(),
                df.getLastName(),
                df.getBirthDate(),
                getAddress()
        );
    }

    /**
     * <b>Description: Method return a list of Person. Returns empty list if N <= 0</b>
     *
     * @param N (number) of persons required
     * @return list
     */
    public List<Person> getPeople(int N) {
        List<Person> people = new ArrayList<>();
        for (int i = 0; i < N; ++i) {
            people.add(getPerson());
        }
        return people;
    }

    /**
     * @return A random Employee
     */
    public Employee getEmployee() {
        return new Employee(
                df.getUUID(),
                df.getItem(IT_DEPARTMENT),
                df.getDouble(),
                getPerson()
        );
    }

    /**
     * <b>Description: Method return a list of Employee. Returns empty list if N <= 0</b>
     *
     * @param N (number) of Employees required
     * @return list
     */
    public List<Employee> getEmployee(int N) {
        List<Employee> employees = new ArrayList<>();
        for (int i = 0; i < N; ++i) {
            employees.add(getEmployee());
        }
        return employees;
    }

}
