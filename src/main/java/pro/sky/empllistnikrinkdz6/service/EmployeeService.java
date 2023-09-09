package pro.sky.empllistnikrinkdz6.service;

import org.springframework.stereotype.Service;
import pro.sky.empllistnikrinkdz6.entity.Employee;
import pro.sky.empllistnikrinkdz6.exception.EmployeeAlreadyAddedException;
import pro.sky.empllistnikrinkdz6.exception.EmployeeNotFoundException;
import pro.sky.empllistnikrinkdz6.exception.EmployeeStorageIsFullException;

import java.util.ArrayList;
import java.util.List;

@Service
public class EmployeeService {

    private static final int CONSTANT = 2;
    private final List<Employee> employees = new ArrayList<>();

    public Employee addEmployee(String firstName, String lastName) {

        if (employees.size() >= CONSTANT) {
            throw new EmployeeStorageIsFullException("Превышен лемит сотрудников");
        }

        Employee empl = new Employee(firstName, lastName);

        if (employees.contains(empl)) {
            throw new EmployeeAlreadyAddedException("Такой сотрудник уже есть");
        }
        employees.add(empl);

        return empl;
    }

    public Employee remove(String firstName, String lastName) {
        Employee empl = new Employee(firstName, lastName);

        if (!employees.contains(empl)) {
            throw new EmployeeNotFoundException("Удалять некого, нет такого сотрудника: " + empl);
        }
        employees.remove(empl);
        return empl;
    }

    public Employee searchEmployee(String firstName, String lastName) {

        Employee empl = new Employee(firstName, lastName);

        if (!employees.contains(empl)) {
            throw new EmployeeNotFoundException("Нет такого сотрудника: " + empl);
        }

        for (Employee employee : employees) {
            if (employee.equals(empl)) {
                System.out.println(employee);
                return employee;
            }
        }
        return null;
    }

    public List<Employee> getEmployeesAll() {
        return employees;
    }

}
