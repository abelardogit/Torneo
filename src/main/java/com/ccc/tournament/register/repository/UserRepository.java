package com.daw.RegistroVideojuegos.repository;

import com.daw.RegistroVideojuegos.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.Optional;

public interface UserRepository extends JpaRepository<User, Long> {


    Optional<User> findByUsernameOrEmail (String username, String email);
}
