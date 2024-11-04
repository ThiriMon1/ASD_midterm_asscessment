package edu.miu.cse.employeemanagement.Service.impl;

import edu.miu.cse.employeemanagement.Service.EmployeeService;
import edu.miu.cse.employeemanagement.domain.Employee;
import edu.miu.cse.employeemanagement.repository.EmployeeRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class EmployeeServiceImpl implements EmployeeService {
    private final EmployeeRepository employeeRepository;
    @Override
    public Optional<Employee> addEmployee(Employee employee) {
        Employee emp = employeeRepository.save(employee);
        return Optional.of(emp);
    }

    @Override
    public Optional<Employee> updateEmployee(Employee employee) {

        return Optional.of(employeeRepository.save(employee));

    }

    @Override
    public void deleteEmployee(Employee employee) {
        employeeRepository.findById(employee.getId()).ifPresent(employee1->{
            employeeRepository.delete(employee1);
        });
    }

    @Override
    public List<Employee> getAllEmployees() {
        return employeeRepository.findAllByOrderBySalaryAscLastNameDesc();
    }
    @Override
    public Optional<Employee> getEmployeeById(int id) {
        return employeeRepository.findById(id);
    }


}
