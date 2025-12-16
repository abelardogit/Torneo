package com.ccc.tournament.shared.domain;

public class
Participant {
    private String gamertag;
    private String email;
    private String game;
    private String role;

    public Participant(String gamertag, String email, String game, String role) {
        this.gamertag = gamertag;
        this.email = email;
        this.game = game;
        this.role = role;
    }

    public String getGamertag() { return gamertag; }
    public String getEmail() { return email; }
    public String getGame() { return game; }
    public String getRole() { return role; }
}
