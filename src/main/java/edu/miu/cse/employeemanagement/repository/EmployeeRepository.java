package edu.miu.cse.employeemanagement.repository;

import edu.miu.cse.employeemanagement.domain.Employee;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface EmployeeRepository extends JpaRepository<Employee, Integer>{
    List<Employee> findAllByOrderBySalaryAscLastNameDesc();
}
