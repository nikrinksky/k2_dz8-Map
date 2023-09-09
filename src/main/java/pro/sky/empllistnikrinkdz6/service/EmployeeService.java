package pro.sky.empllistnikrinkdz6.service;

import org.springframework.stereotype.Service;
import org.springframework.web.servlet.function.ServerRequest;
import pro.sky.empllistnikrinkdz6.entity.Employee;
import pro.sky.empllistnikrinkdz6.exception.EmployeeAlreadyAddedException;
import pro.sky.empllistnikrinkdz6.exception.EmployeeNotFoundException;
import pro.sky.empllistnikrinkdz6.exception.EmployeeStorageIsFullException;

import java.util.*;

@Service
public class EmployeeService {

    private static final int CONSTANT = 2;
    private final Map<String, Employee> employees = new HashMap<>();

    public Employee addEmployee(String firstName, String lastName) {

        if (employees.size() >= CONSTANT) {
            throw new EmployeeStorageIsFullException("Превышен лемит сотрудников");
        }

        String key = getKey(firstName, lastName);
        if(employees.containsKey(key)){
            throw new EmployeeAlreadyAddedException("Такой сотрудник уже есть");
        }

        Employee empl = new Employee(firstName, lastName);

        employees.put(key, empl);

        return empl;
    }

    public Employee remove(String firstName, String lastName) {

        String key = getKey(firstName, lastName);

        if (!employees.containsKey(key)) {
            throw new EmployeeNotFoundException("Удалять некого, нет такого сотрудника: " + key);
        }
        return employees.remove(key);
    }

    public Employee searchEmployee(String firstName, String lastName) {
        String key = getKey(firstName, lastName);

        if (!employees.containsKey(key)) {
            throw new EmployeeNotFoundException("Нет такого сотрудника: " + key);
        } else  {
            return employees.get(key);
        }
    }

    public Collection<Employee> getEmployeesAll() {
        return employees.values();
    }

    private String getKey(String firstName, String lastName){
        return firstName + " " + lastName;
    }

}
