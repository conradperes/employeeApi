package com.employee.rest.employeeApi.restaurant.repository;


import com.employee.rest.employeeApi.restaurant.entity.Item;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ItemRepository extends JpaRepository<Item, Long> {
}
