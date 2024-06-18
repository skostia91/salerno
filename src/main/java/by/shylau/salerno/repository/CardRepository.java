package by.shylau.salerno.repository;


import by.shylau.salerno.model.Card;
import by.shylau.salerno.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface CardRepository extends JpaRepository<Card, Integer> {

}
