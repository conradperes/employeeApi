package com.employee.rest.employeeApi.restaurant.repository;

import com.employee.rest.employeeApi.restaurant.entity.Order;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderRepository extends JpaRepository<Order, Long> {
}
