package com.ccc.tournament.dashboard.gamescrud.createnewgame.domain.service;

import com.ccc.tournament.dashboard.gamescrud.createnewgame.application.NewGameRequest;
import com.ccc.tournament.shared.domain.Game;
import com.ccc.tournament.shared.domain.GameRepository;
import org.springframework.stereotype.Service;

@Service
public class CreateNewGameService {

    private final GameRepository gameRepository;

    public CreateNewGameService(GameRepository gameRepository) {this.gameRepository = gameRepository;}

    public void execute(NewGameRequest request) {
        Game game = new Game(
                request.getName(),
                request.getDescription(),
                request.getAssociatedID(),
                request.getBannerImage(),
                request.getCardImage()
        );
        gameRepository.save(game);
    }

}
