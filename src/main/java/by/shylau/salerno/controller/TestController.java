package by.shylau.salerno.controller;

import by.shylau.salerno.repository.CardRepository;
import by.shylau.salerno.repository.OrderRepository;
import by.shylau.salerno.repository.UserRepository;
import by.shylau.salerno.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequiredArgsConstructor
@RestController
@RequestMapping("/trest")
public class TestController {
    private final UserRepository userRepository;
    private final CardRepository cardRepository;
    private final OrderRepository orderRepository;

    @GetMapping
    public void foo() {
        var a = userRepository.findById(1).get();
        var b = cardRepository.findById(1).get();
        var c = orderRepository.findById(1).get();

        System.out.println(a.getCard().getNumber());
        System.err.println("---------------");
        System.out.println(a.getOrders());
//        System.err.println("---------------");
//        System.out.println(b.getUser().getOrders().get(2).getUser().getEmail());
    }
}
