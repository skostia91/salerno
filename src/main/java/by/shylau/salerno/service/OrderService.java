package by.shylau.salerno.service;

import by.shylau.salerno.dto.request.OrderRequest;
import by.shylau.salerno.dto.responce.OrderResponse;
import by.shylau.salerno.exception.NotFoundException;
import by.shylau.salerno.mapper.OrderMapper;
import by.shylau.salerno.model.Order;
import by.shylau.salerno.model.User;
import by.shylau.salerno.repository.OrderRepository;
import by.shylau.salerno.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
@Slf4j
public class OrderService {

    private final OrderRepository orderRepository;
    private final UserRepository userRepository;
    private final UserService userService;
    private final OrderMapper orderMapper;

    public void saveOrder(OrderRequest orderRequest) {
        int idUser = orderRequest.getIdUser();

        User user = userRepository.findById(idUser).orElseThrow(() -> {
            String message = String.format("Order with id %s not found", idUser);
            log.error(message);
            throw new NotFoundException(message);
        });

        Order order = orderMapper.createOrder(orderRequest);
        order.setUser(user);
        orderRepository.save(order);
        log.info("order save {}", order);
    }

    public List<OrderResponse> getOrderByUserId(int id) {
        User user = userService.getUserById(id);
        return orderMapper.toResponseList(user.getOrders());
    }

    public OrderResponse getOrderById(int id) {
        Order order = orderRepository.findById(id).orElseThrow(() -> {
            String message = String.format("Order by id %d is not found", id);
            log.error(message);
            throw new NotFoundException(message);
        });
        return orderMapper.toResponse(order);
    }

    public List<OrderResponse> getAllOrders() {
        return orderRepository.findAll(Sort.by(Sort.Direction.ASC, "price"))
                .stream()
                .map(orderMapper::toResponse)
                .toList();
    }

    @Transactional
    public void deleteOrder(int id) {
        existsOrder(id);
        log.info("Deleting order id = {}", id);
        orderRepository.deleteById(id);
    }

    private void existsOrder(int id) {
        if (!orderRepository.existsById(id)) {
            String message = String.format("Order by id %d is not found", id);
            log.error(message);
            throw new NotFoundException(message);
        }
    }
}