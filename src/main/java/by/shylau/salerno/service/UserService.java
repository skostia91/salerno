package by.shylau.salerno.service;

import by.shylau.salerno.dto.request.CardRequest;
import by.shylau.salerno.dto.request.UserRequest;
import by.shylau.salerno.dto.responce.CardResponse;
import by.shylau.salerno.dto.responce.UserResponse;
import by.shylau.salerno.exception.NotFoundException;
import by.shylau.salerno.mapper.CardMapper;
import by.shylau.salerno.mapper.UserMapper;
import by.shylau.salerno.model.User;
import by.shylau.salerno.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
@Slf4j
public class UserService {
    private final UserRepository userRepository;
    private final UserMapper userMapper;
    private final CardMapper cardMapper;

    public void createUser(UserRequest userRequest) {
        User user = userMapper.createUser(userRequest);
        userRepository.save(user);
    }

    public List<UserResponse> getAllUsers() {
        return userMapper.toResponseList(userRepository.findAll());
    }

    public User getUserById(int id) {
        return userRepository.findById(id).orElseThrow(() -> {
            String message = String.format("User with id %d is not found", id);
            log.error(message);
            throw new NotFoundException(message);
        });
    }

    public CardResponse getCardByUserId(int id) {
        var card = getUserById(id).getCard();
        return cardMapper.toResponse(card);
    }
}
