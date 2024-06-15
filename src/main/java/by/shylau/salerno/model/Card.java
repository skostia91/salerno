package by.shylau.salerno.model;

import jakarta.persistence.*;

@Entity
@Table(name = "cards")
public class Card {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String number;

    @OneToOne(mappedBy = "card", cascade = CascadeType.ALL)
    private User user;
}
