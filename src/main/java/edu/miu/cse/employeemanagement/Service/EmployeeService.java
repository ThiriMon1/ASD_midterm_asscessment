package edu.miu.cse.employeemanagement.Service;

import edu.miu.cse.employeemanagement.domain.Employee;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public interface EmployeeService {
    Optional<Employee> addEmployee(Employee employee);
    Optional<Employee> updateEmployee(Employee employee);
    void deleteEmployee(Employee employee);
    List<Employee> getAllEmployees();
    Optional<Employee> getEmployeeById(int id);
}
