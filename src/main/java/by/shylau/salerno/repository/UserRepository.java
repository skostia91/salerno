package by.shylau.salerno.repository;

import by.shylau.salerno.model.*;
import org.springframework.data.jpa.repository.*;


public interface UserRepository extends JpaRepository<User, Integer> {
}
