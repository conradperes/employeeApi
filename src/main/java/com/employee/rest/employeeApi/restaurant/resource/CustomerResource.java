package com.employee.rest.employeeApi.restaurant.resource;

import com.employee.rest.employeeApi.employee.entity.Employee;
import com.employee.rest.employeeApi.restaurant.entity.Customer;
import com.employee.rest.employeeApi.restaurant.repository.CustomerRepository;
import com.employee.rest.employeeApi.restaurant.repository.ItemRepository;
import com.employee.rest.employeeApi.restaurant.repository.OrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import javax.validation.Valid;
import java.net.URI;
import java.util.List;

@RestController
//@CrossOrigin(origins = "http://localhost:4200")
public class CustomerResource {
    @Autowired
    private CustomerRepository customerRepository;

    @PostMapping("/api/customer")
    //@CrossOrigin(origins = "http://localhost:4200")
    public ResponseEntity<Object> insertCustomer(@Valid @RequestBody Customer customer){
        Customer emp = customerRepository.save(customer);
        URI location = ServletUriComponentsBuilder
                .fromCurrentRequest()
                .path("/{id}")
                .buildAndExpand(emp.getCustomerID()).toUri();

        return ResponseEntity.created(location).build();

    }

    @GetMapping("/api/customer")
    @CrossOrigin(origins = "http://localhost:4200")
    public List<Customer> findAllCustomers(){
        return customerRepository.findAll();
    }

    @DeleteMapping("/api/customer/{id}")
    //@CrossOrigin(origins = "http://localhost:4200")
    public void deleteCustomer(@PathVariable Long id) { customerRepository.deleteById(id); }

    @PutMapping("/api/customer")
    //@CrossOrigin(origins = "http://localhost:4200")
    public ResponseEntity<Object>  updateCustomer(@Valid @RequestBody Customer customer){
        customerRepository.save(customer);
                URI location = ServletUriComponentsBuilder
                .fromCurrentRequest()
                .path("/{id}")
                .buildAndExpand(customer.getCustomerID()).toUri();

        return ResponseEntity.created(location).build();

    }
}
