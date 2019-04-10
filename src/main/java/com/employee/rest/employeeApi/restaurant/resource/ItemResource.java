package com.employee.rest.employeeApi.restaurant.resource;

import com.employee.rest.employeeApi.restaurant.entity.Item;
import com.employee.rest.employeeApi.restaurant.entity.Order;
import com.employee.rest.employeeApi.restaurant.repository.ItemRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import javax.validation.Valid;
import java.net.URI;
import java.util.List;
import java.util.Optional;

@RestController
public class ItemResource {

    public static final String ERROR_MESSAGE_ITEM = "There's no item with this id=";
    @Autowired
    private ItemRepository itemRepository;


    @PostMapping("/api/item")
    //@CrossOrigin(origins = "http://localhost:4200")
    public ResponseEntity<Object> insertItem(@Valid @RequestBody Item item){
        Item itemSaved = itemRepository.save(item);
        URI location = ServletUriComponentsBuilder
                .fromCurrentRequest()
                .path("/{id}")
                .buildAndExpand(itemSaved.getItemID()).toUri();

        return ResponseEntity.created(location).build();

    }

    @GetMapping("/api/items/{id}")
    @CrossOrigin(origins = "http://localhost:4200")
    public Item getItemById(@PathVariable long id){
        Optional<Item> itemOptional=null;
        try {
            itemOptional = itemRepository.findById(id);
            if (itemOptional.get().getItemID() == 0)
                throw new OrderNortFoundException(ERROR_MESSAGE_ITEM +id);

        }catch (Exception e ){
            throw new OrderNortFoundException(ERROR_MESSAGE_ITEM +id);
        }

        return itemOptional.get();

    }

    @GetMapping("/api/item")
    @CrossOrigin(origins = "http://localhost:4200")
    public List<Item> findAllItems(){
        return itemRepository.findAll();
    }

    @DeleteMapping("/api/item/{id}")
    //@CrossOrigin(origins = "http://localhost:4200")
    public void deleteItem(@PathVariable Long id) {itemRepository.deleteById(id); }

    @PutMapping("/api/item")
    //@CrossOrigin(origins = "http://localhost:4200")
    public ResponseEntity<Object>updateItem(@Valid @RequestBody Item item){
        @Valid Item itemSaved = itemRepository.save(item);
        URI location = ServletUriComponentsBuilder
                .fromCurrentRequest()
                .path("/{id}")
                .buildAndExpand(itemSaved.getItemID()).toUri();

        return ResponseEntity.created(location).build();

    }
}
