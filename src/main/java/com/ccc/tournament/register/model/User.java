package com.daw.RegistroVideojuegos.model;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
@Table(name="users")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long user_id;

    @Column(name="first_name")
    private String firstName;

    @Column(name="last_name")
    private String lastName;

    @Column(name="email", unique = true, nullable = false)
    private String email;

    @Column(name="password_hash", nullable = false)
    private String password; // Almacenará el hash de la contraseña

    @Column(name="username", unique = true, nullable = false)
    private String username;

    @Column(name="riot_id")
    private String riotId;

    @Column(name="epic_id")
    private String epicId;

    @Column(name="fifa_id")
    private String fifaId;
}