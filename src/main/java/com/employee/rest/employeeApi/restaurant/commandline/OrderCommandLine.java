package com.employee.rest.employeeApi.restaurant.commandline;

import com.employee.rest.employeeApi.restaurant.entity.Customer;
import com.employee.rest.employeeApi.restaurant.entity.Item;
import com.employee.rest.employeeApi.restaurant.entity.Order;


import com.employee.rest.employeeApi.restaurant.repository.CustomerRepository;
import com.employee.rest.employeeApi.restaurant.repository.ItemRepository;
import com.employee.rest.employeeApi.restaurant.repository.OrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Component
public class OrderCommandLine implements CommandLineRunner {

    @Autowired
    private OrderRepository orderRepository;

    @Autowired
    private ItemRepository itemRepository;

    @Autowired
    private CustomerRepository customerRepository;

//    Item item;
    Customer customer;

    @Override
    public void run(String... args) throws Exception {


        customer = insertCustomer();
        Item item = new Item("Banana", new BigDecimal("3.777"));
        Item item2 = new Item("Maça", new BigDecimal("1.777"));
        Item item3 = new Item("Uva", new BigDecimal("2.777"));
        Item item4 = new Item("Kiwi", new BigDecimal("0.777"));
        Item item5 = new Item("Melancia", new BigDecimal("4.777"));
        Item item6 = new Item("Abacaxi", new BigDecimal("5.777"));
        Item item7 = new Item("Hortela", new BigDecimal("7.777"));
        Order pedido = new Order("xxx","$",new BigDecimal("3.777") );
        Order pedido1 = new Order("12341234","$",new BigDecimal("3.777") );
        pedido1.setCustomer(customer);
        pedido.setCustomer(customer);
        item.setPedidos(Arrays.asList(pedido));



//        pedido.setCustomer(customer);
        pedido.setItems(Arrays.asList(item));
        itemRepository.save(item);
        itemRepository.save(item2);
        itemRepository.save(item3);
        itemRepository.save(item4);
        itemRepository.save(item5);
        itemRepository.save(item6);
        itemRepository.save(item7);
        orderRepository.save(pedido);
        orderRepository.save(pedido1);







    }

    private Customer insertCustomer() {
        List<Order> orders = new ArrayList<Order>();
        orders.add(new Order());
        Customer customer = new Customer("Conrad");//,orders );
        customerRepository.save(customer);
        return customer;
    }


}
