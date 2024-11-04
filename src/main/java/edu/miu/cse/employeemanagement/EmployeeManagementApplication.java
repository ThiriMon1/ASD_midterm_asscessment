package edu.miu.cse.employeemanagement;

import edu.miu.cse.employeemanagement.Service.EmployeeService;
import edu.miu.cse.employeemanagement.domain.Employee;
import edu.miu.cse.employeemanagement.repository.EmployeeRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
@RequiredArgsConstructor
public class EmployeeManagementApplication {
    private final EmployeeService employeeService;

    public static void main(String[] args) {
        SpringApplication.run(EmployeeManagementApplication.class, args);
    }

    @Bean
    CommandLineRunner commandLineRunner(EmployeeService employeeService) {
        return args -> {
            // create employee
            employeeService.addEmployee(new Employee("John", "Doe", 50000));
            employeeService.addEmployee(new Employee("Jane", "Dona", 50000));
            employeeService.addEmployee(new Employee("Alice", "Smith", 60000));
            employeeService.addEmployee(new Employee("Bob", "Brown", 45000));

            System.out.println("print all employee");
            employeeService.getAllEmployees().forEach(System.out::println);

            //update
            Employee emp1 =employeeService.getEmployeeById(1).get();
            emp1.setFirstName("Test");
            employeeService.updateEmployee(emp1);
            System.out.println("print update employee");
            employeeService.getAllEmployees().forEach(System.out::println);

            employeeService.deleteEmployee(emp1);
            System.out.println("print delete employee");
            employeeService.getAllEmployees().forEach(System.out::println);


        };
    }
}
