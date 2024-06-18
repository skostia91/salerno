package by.shylau.salerno.controller;

import by.shylau.salerno.dto.request.OrderRequest;
import by.shylau.salerno.dto.responce.OrderResponse;
import by.shylau.salerno.service.OrderService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/orders")
@RequiredArgsConstructor
public class OrderController {
    private final OrderService orderService;

    //работает
    @GetMapping
    public ResponseEntity<List<OrderResponse>> getAllOrders() {
        return ResponseEntity.ok(orderService.getAllOrders());
    }

    //работает
    @PostMapping
    public ResponseEntity<Void> saveOrder(@RequestBody OrderRequest orderRequest) {
        orderService.saveOrder(orderRequest);
        return ResponseEntity.ok().build();
    }

    //работает
    @GetMapping("/{id}")
    public ResponseEntity<List<OrderResponse>> getOrdersForUser(@PathVariable int id) {
        return ResponseEntity.ok(orderService.getOrderByUserId(id));
    }
}
