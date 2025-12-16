package com.ccc.tournament.dashboard.gamescrud.createnewgame.application;

import com.ccc.tournament.dashboard.gamescrud.createnewgame.domain.service.CreateNewGameService;
import org.springframework.stereotype.Service;

@Service
public class CreateNewGameApp {

    private final CreateNewGameService newGameService;

    public CreateNewGameApp(CreateNewGameService newGameService){this.newGameService = newGameService;}

    public void execute(NewGameRequest request){newGameService.execute(request);}

}
