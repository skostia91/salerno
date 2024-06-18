package by.shylau.salerno.controller;

import by.shylau.salerno.dto.request.UserRequest;
import by.shylau.salerno.dto.responce.CardResponse;
import by.shylau.salerno.dto.responce.UserResponse;
import by.shylau.salerno.service.UserService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/users")
@RequiredArgsConstructor
@Slf4j
public class UserController {
    private final UserService userService;

    //работает
    @GetMapping
    public ResponseEntity<List<UserResponse>> getAllUsers() {
        return ResponseEntity.ok(userService.getAllUsers());
    }

    //работает
    @PostMapping
    public ResponseEntity<Void> createUser(@RequestBody @Valid UserRequest userRequest) {
        log.info("create user {}", userRequest);
        userService.createUser(userRequest);
        return ResponseEntity.ok().build();
    }

    //работает
    @GetMapping("/{id}")
    public ResponseEntity<CardResponse> getCardByUser(@PathVariable int id) {
        return ResponseEntity.ok(userService.getCardByUserId(id));
    }

}
