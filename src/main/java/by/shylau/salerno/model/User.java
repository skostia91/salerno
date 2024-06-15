package by.shylau.salerno.model;

import jakarta.persistence.*;
import lombok.*;

import java.util.*;

@NoArgsConstructor
@Getter
@Setter
@Table(name = "users")
@Entity
@AllArgsConstructor
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String login;

    private Double age;

    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id")
    private List<Order> orders;

    @OneToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id")
    private Card card;

    public void add(Order order) {
        orders.add(order);
    }
}