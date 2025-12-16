package com.daw.RegistroVideojuegos.model;

import lombok.Data;

@Data
public class RegisterRequest {
    private String firstName;
    private String lastName;
    private String email;
    private String password;
    private String username;
    private String riotId;
    private String epicId;
    private String fifaId;
}