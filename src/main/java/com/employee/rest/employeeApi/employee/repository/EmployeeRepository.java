package com.employee.rest.employeeApi.employee.repository;

import com.employee.rest.employeeApi.employee.entity.Employee;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EmployeeRepository extends JpaRepository<Employee, Long>{
}
