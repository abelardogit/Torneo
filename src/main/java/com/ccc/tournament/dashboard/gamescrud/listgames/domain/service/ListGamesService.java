package com.ccc.tournament.dashboard.gamescrud.listgames.domain.service;

import com.ccc.tournament.shared.domain.Game;
import com.ccc.tournament.shared.domain.GameRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ListGamesService {

    @Autowired
    private final GameRepository gameRepository;

    public ListGamesService(GameRepository gameRepository) {this.gameRepository = gameRepository;}

    public List<Game> listAllGames(){return gameRepository.findAll();}

}
