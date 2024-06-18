package by.shylau.salerno.service;

import by.shylau.salerno.dto.request.CardRequest;
import by.shylau.salerno.dto.responce.CardResponse;
import by.shylau.salerno.dto.responce.UserResponse;
import by.shylau.salerno.exception.NotFoundException;
import by.shylau.salerno.mapper.CardMapper;
import by.shylau.salerno.mapper.UserMapper;
import by.shylau.salerno.model.Card;
import by.shylau.salerno.repository.CardRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Slf4j
@RequiredArgsConstructor
public class CardService {
    private final CardMapper cardMapper;
    private final CardRepository cardRepository;
    private final UserMapper userMapper;

    public List<CardResponse> getAllCards() {
        var cardList = cardRepository.findAll();
        return cardMapper.toResponseList(cardList);
    }

    public UserResponse getUserByCardId(int cardId) {
        var card = cardRepository.findById(cardId).orElseThrow(() -> {
            String message = String.format("Card with id %d is not found", cardId);
            log.error(message);
            throw new NotFoundException(message);
        });
        return userMapper.toResponse(card.getUser());
    }

    public CardResponse getCardId(int cardId) {
        var card = cardRepository.findById(cardId).orElseThrow(() -> {
            String message = String.format("Card with id %d is not found", cardId);
            log.error(message);
            throw new NotFoundException(message);
        });
        return cardMapper.toResponse(card);
    }

    public void saveCard(CardRequest cardRequest) {
        Card card = cardMapper.createCard(cardRequest);
        cardRepository.save(card);
    }
}
