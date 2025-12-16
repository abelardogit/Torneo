package com.ccc.tournament.dashboard.gamescrud.createnewgame.application;

import com.ccc.tournament.shared.domain.AssociatedID;

public class NewGameRequest {

    private String name;
    private String description;
    private AssociatedID associatedID;
    private String bannerImage;
    private String cardImage;

    public NewGameRequest(){}

    public NewGameRequest(String name, String description, AssociatedID associatedID, String bannerImage, String cardImage) {
        this.name = name;
        this.description = description;
        this.associatedID = associatedID;
        this.bannerImage = bannerImage;
        this.cardImage = cardImage;
    }

    public String getName() {return name;}
    public String getDescription() {return description;}
    public AssociatedID getAssociatedID() {return associatedID;}
    public String getBannerImage() {return bannerImage;}
    public String getCardImage() {return cardImage;}

    public void setName(String name) {this.name = name;}
    public void setDescription(String description) {this.description = description;}
    public void setAssociatedID(AssociatedID associatedID) {this.associatedID = associatedID;}
    public void setBannerImage(String bannerImage) {this.bannerImage = bannerImage;}
    public void setCardImage(String cardImage) {this.cardImage = cardImage;}
}