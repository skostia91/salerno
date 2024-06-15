package by.shylau.salerno.controller;

import by.shylau.salerno.model.*;
import by.shylau.salerno.repository.*;
import lombok.*;
import org.springframework.http.*;
import org.springframework.web.bind.annotation.*;

import java.util.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/users")
public class UserController {

    private final UserRepository userRepository;

    //работает
    @GetMapping
    public ResponseEntity<List<User>> getAllUsers() {
        return ResponseEntity.ok(userRepository.findAll());
    }

    //работает
    @PostMapping
    public void createUser(@RequestBody User user) {
        userRepository.save(user);
    }
}
