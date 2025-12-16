package com.ccc.tournament.dashboard.gamescrud.listgames.application;

import com.ccc.tournament.dashboard.gamescrud.listgames.domain.service.ListGamesService;
import com.ccc.tournament.shared.domain.Game;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ListGamesApp {

    private final ListGamesService listGamesService;

    public ListGamesApp(ListGamesService listGamesService) {this.listGamesService = listGamesService;}

    public List<Game> execute(){return listGamesService.listAllGames();}
}
