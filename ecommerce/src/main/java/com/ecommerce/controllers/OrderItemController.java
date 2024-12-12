package com.ecommerce.controllers;

import com.ecommerce.entities.OrderItem;
import com.ecommerce.repositories.OrderItemRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/order-items")
public class OrderItemController {

    @Autowired
    private OrderItemRepository orderItemRepository;

    @GetMapping
    public List<OrderItem> listOrderItems(){
        return orderItemRepository.findAll();
    }

    @PostMapping
    public OrderItem addOrderItem(@RequestBody OrderItem orderItem){
        return orderItemRepository.save(orderItem);
    }

    @GetMapping("/{id}")
    public OrderItem getOrderItem(@PathVariable Long id){
        return orderItemRepository.findById(id).orElse(null);
    }

    @DeleteMapping("/{id}")
    public void deleteOrderItem(@PathVariable Long id){
        orderItemRepository.deleteById(id);
    }
}
