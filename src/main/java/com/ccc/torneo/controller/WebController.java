package com.ccc.torneo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class WebController {


    @GetMapping({"/","/index.html"})
    public String index() {
        return "index";
    }

    @GetMapping("/usuarios.html")
    public String usuarios() {
        return "usuarios";
    }

    @GetMapping("/juegos.html")
    public String juegos() {
        return "juegos";
    }

    @GetMapping("/torneos.html")
    public String torneos() {
        return "torneos";
    }


    @GetMapping("/crear-usuario.html")
    public String crearUsuario() {
        return "crear-usuario";
    }

    @GetMapping("/crear-juego.html")
    public String crearJuego() {
        return "crear-juego";
    }

    @GetMapping("/crear-torneo.html")
    public String crearTorneo() {
        return "crear-torneo";
    }
}