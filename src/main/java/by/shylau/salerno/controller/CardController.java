package by.shylau.salerno.controller;

import by.shylau.salerno.model.*;
import by.shylau.salerno.repository.*;
import lombok.*;
import org.springframework.transaction.annotation.*;
import org.springframework.web.bind.annotation.*;

import java.util.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/cards")
public class CardController {
    private final CardRepository cardRepository;
    private final UserRepository userRepository;

    @GetMapping
    public List<Card> getCards() {
        return cardRepository.findAll();
    }

    @PostMapping
    @Transactional
    public void addCard(@RequestBody Card card, @PathVariable int id) {
        User user = userRepository.findById(id).get();
        user.setCard(card);
        cardRepository.save(card);

    }
}
