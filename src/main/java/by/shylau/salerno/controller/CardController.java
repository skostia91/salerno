package by.shylau.salerno.controller;

import by.shylau.salerno.dto.request.CardRequest;
import by.shylau.salerno.dto.responce.CardResponse;
import by.shylau.salerno.dto.responce.UserResponse;
import by.shylau.salerno.model.Card;
import by.shylau.salerno.repository.CardRepository;
import by.shylau.salerno.repository.UserRepository;
import by.shylau.salerno.service.CardService;
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
@RequiredArgsConstructor
@RequestMapping("/cards")
public class CardController {
    private final CardService cardService;

    @GetMapping
    public ResponseEntity<List<CardResponse>> getCards() {
        return ResponseEntity.ok(cardService.getAllCards());
    }

    @GetMapping("/user/{cardId}")
    public ResponseEntity<UserResponse> getUserByCardId(@PathVariable int cardId) {
        return ResponseEntity.ok(cardService.getUserByCardId(cardId));
    }

    @GetMapping("/{cardId}")
    public ResponseEntity<CardResponse> getCardById(@PathVariable int cardId) {
        return ResponseEntity.ok(cardService.getCardId(cardId));
    }


    @PostMapping("/{id}")
    public void saveCard(@RequestBody CardRequest card) {
        cardService.saveCard(card);
    }
}
