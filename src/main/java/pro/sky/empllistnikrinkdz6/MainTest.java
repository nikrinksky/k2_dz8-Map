package pro.sky.empllistnikrinkdz6;

import pro.sky.empllistnikrinkdz6.service.EmployeeService;

public class MainTest {
    public static void main(String[] args) {
        EmployeeService employeeService = new EmployeeService();
        System.out.println(employeeService);
        employeeService.addEmployee("Nik1", "Rad1");
        System.out.println(employeeService);
        employeeService.addEmployee("Nik2", "Rad2");
        employeeService.addEmployee("Nik3", "Rad3");
        System.out.println(employeeService);
        employeeService.addEmployee("Nik4", "Rad4");
        System.out.println(employeeService);
        employeeService.searchEmployee("Nik2", "Rad2");
//        employeeService.addEmployee("Nik5", "Rad5");
//
//        employeeService.deleteEmployee("Nik3", "Rad3");

        //System.out.println(employeeService);
        //employeeService.deleteEmployee("Nik3", "Rad3");
        //employeeService.addEmployee("Nik6", "Rad6");
        //System.out.println(employeeService);
//        employeeService.deleteEmployee("Nik2", "Rad3");
        //System.out.println(employeeService.employees.size());
//        employeeService.searchEmployee("Nik4", "Rad2");
        //employeeService.searchEmployee("Nik3", "Rad3");



    }
}
