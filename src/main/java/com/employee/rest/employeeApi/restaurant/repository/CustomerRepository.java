package com.employee.rest.employeeApi.restaurant.repository;

import com.employee.rest.employeeApi.restaurant.entity.Customer;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CustomerRepository extends JpaRepository<Customer, Long> {

}
