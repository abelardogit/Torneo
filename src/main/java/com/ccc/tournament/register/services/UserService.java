package com.daw.RegistroVideojuegos.services;

import com.daw.RegistroVideojuegos.model.RegisterRequest;
import com.daw.RegistroVideojuegos.model.User;
import com.daw.RegistroVideojuegos.repository.UserRepository;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserService {

    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;

    public UserService(UserRepository userRepository, PasswordEncoder passwordEncoder) {
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
    }

    public Optional<User> registerUser(RegisterRequest registerRequest) {

        // 1. Verificar si el nombre de usuario o email ya existen
        Optional<User> existingUser = userRepository.findByUsernameOrEmail(
                registerRequest.getUsername(),
                registerRequest.getEmail()
        );

        if (existingUser.isPresent()) {
            return Optional.empty();
        }

        // 2. Crear y mapear el nuevo objeto User
        User newUser = new User();
        newUser.setFirstName(registerRequest.getFirstName());
        newUser.setLastName(registerRequest.getLastName());
        newUser.setEmail(registerRequest.getEmail());
        newUser.setUsername(registerRequest.getUsername());

        // 3. ¡Codificar la contraseña!
        String encodedPassword = passwordEncoder.encode(registerRequest.getPassword());
        newUser.setPassword(encodedPassword);

        // 4. Mapear IDs de juego
        newUser.setRiotId(registerRequest.getRiotId());
        newUser.setEpicId(registerRequest.getEpicId());
        newUser.setFifaId(registerRequest.getFifaId());

        // 5. Guardar el nuevo usuario en la base de datos
        User savedUser = userRepository.save(newUser);
        return Optional.of(savedUser);
    }
}