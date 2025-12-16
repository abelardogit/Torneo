package com.daw.RegistroVideojuegos.controllers;

import com.daw.RegistroVideojuegos.model.RegisterRequest;
import com.daw.RegistroVideojuegos.services.UserService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/jugador")
public class JugadorController {

    private final UserService userService;

    public JugadorController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping("/registrar")
    public ResponseEntity<?> registrarJugador(@RequestBody RegisterRequest registerRequest) {

        return userService.registerUser(registerRequest)
                .map(user -> ResponseEntity.status(HttpStatus.CREATED).body(user)) // 201 Created (Éxito)
                .orElse(ResponseEntity.status(HttpStatus.CONFLICT).body(null));
    }
}