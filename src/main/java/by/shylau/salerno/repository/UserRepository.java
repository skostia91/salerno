package by.shylau.salerno.repository;

import by.shylau.salerno.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Integer> {
}
