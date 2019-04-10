package com.employee.rest.employeeApi.restaurant.resource;

import com.employee.rest.employeeApi.restaurant.entity.Item;
import com.employee.rest.employeeApi.restaurant.entity.Order;
import com.employee.rest.employeeApi.restaurant.repository.ItemRepository;
import com.employee.rest.employeeApi.restaurant.repository.OrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.hateoas.Resource;
import org.springframework.hateoas.mvc.ControllerLinkBuilder;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import javax.validation.Valid;
import java.net.URI;
import java.util.List;
import java.util.Optional;

import static org.springframework.hateoas.mvc.ControllerLinkBuilder.linkTo;
import static org.springframework.hateoas.mvc.ControllerLinkBuilder.methodOn;

@RestController
public class OrderResource {
    public static final String ERROR_MESSAGE_ORDER = "There's no order with this id=";
    @Autowired
    private OrderRepository orderRepository;

    @PostMapping("/api/order")
    @CrossOrigin(origins = "http://localhost:4200")
    public ResponseEntity<Object> insertOrder(@Valid @RequestBody Order order){
        Order itemSaved = orderRepository.save(order);
        URI location = ServletUriComponentsBuilder
                .fromCurrentRequest()
                .path("/{id}")
                .buildAndExpand(itemSaved.getOrderID()).toUri();
        return ResponseEntity.created(location).build();
    }

    @GetMapping("/api/order")
    @CrossOrigin(origins = "http://localhost:4200")
    public List<Order> findAllOrders(){
        return orderRepository.findAll();
    }


    @GetMapping("/api/order/{id}")
    @CrossOrigin(origins = "http://localhost:4200")
    public Order getOrderById(@PathVariable long id){
        Optional<Order> orderOptional=null;
        try {
            orderOptional = orderRepository.findById(id);
            if (orderOptional.get().getOrderID() == 0)
                throw new OrderNortFoundException(ERROR_MESSAGE_ORDER+id);

        }catch (Exception e ){
            throw new OrderNortFoundException(ERROR_MESSAGE_ORDER+id);
        }

        return orderOptional.get();

    }

    @DeleteMapping("/api/order/{id}")
    @CrossOrigin(origins = "http://localhost:4200")
    public void deleteOrder(@PathVariable Long id) {orderRepository.deleteById(id); }

    @PutMapping("/api/order/edit")
    @CrossOrigin(origins = "http://localhost:4200")
    public ResponseEntity<Object> updateOrder(@Valid @RequestBody Order order){
        @Valid Order itemSaved = orderRepository.save(order);
        URI location = ServletUriComponentsBuilder
                .fromCurrentRequest()
                .path("/{id}")
                .buildAndExpand(itemSaved.getOrderID()).toUri();
      return ResponseEntity.created(location).build();
    }
}

