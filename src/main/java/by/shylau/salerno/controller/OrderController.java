package by.shylau.salerno.controller;

import by.shylau.salerno.model.*;
import by.shylau.salerno.repository.*;
import lombok.*;
import org.springframework.http.*;
import org.springframework.web.bind.annotation.*;

import java.util.*;


@RestController
@RequestMapping("/orders")
@RequiredArgsConstructor
public class OrderController {
    private final OrderRepository orderRepository;
    private final UserRepository userRepository;

    //работает
    @GetMapping
    public ResponseEntity<List<Order>> getAllOrders() {
        return ResponseEntity.ok(orderRepository.findAll());
    }


    @PostMapping("/{id}")
    public void saveOrder(@RequestBody Order order, @PathVariable int id) {
        User user = userRepository.findById(id).get();
        user.add(order);
        orderRepository.save(order);
    }

}
