
## Documentation

You can use DataFactory, PojoFactory or JsonFactory for generating test data.

PojoFactory usage
```
PojoFactory pf = new PojoFactory();
Person person = pf.getPerson();
List<Person> personList = pf.getPeople(5);

Employee employee = pf.getEmployee();
List<Employee> employees = pf.getEmployee(5);
```

JsonFactory usage
```
JsonFactory jf = new JsonFactory();
String personJson = jf.getPerson();
String employeeJson = jf.getEmployee();
```

DataFactory usage

```
DataFactory df = new DataFactory();
String firstName = df.getFirstName();
String lastName = df.getLastName();
LocalDate dob = df.getBirthDate();
```

more test data to come