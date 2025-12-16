package com.ccc.tournament.dashboard.participantsCrud.CreateNewParticipant.application;

public class NewParticipantRequest {
    private String gamertag;
    private String email;
    private String game;
    private String role;

    public NewParticipantRequest(){}

    public NewParticipantRequest(String gamertag, String email, String game, String role) {
        this.gamertag = gamertag;
        this.email = email;
        this.game = game;
        this.role = role;
    }

    public String getGamertag() {return gamertag;}
    public String getEmail() {return email;}
    public String getGame() {return game;}
    public String getRole() {return role;}

    public void setGamertag(String gamertag) {this.gamertag = gamertag;}
    public void setEmail(String email) {this.email = email;}
    public void setGame(String game) {this.game = game;}
    public void setRole(String role) {this.role = role;}
}
