package com.ccc.tournament.dashboard.participantsCrud.DeleteParticipant.infra;

import com.ccc.tournament.dashboard.participantsCrud.DeleteParticipant.application.DeleteParticipantApp;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/participantes")

public class DeleteParticipantController {
    DeleteParticipantApp deleteParticipantApp;

    public DeleteParticipantController(DeleteParticipantApp deleteParticipantApp) {
        this.deleteParticipantApp = deleteParticipantApp;
    }

    @PostMapping("/delete")
    public String delete(@RequestParam("gamertag") String gamertag) {
        System.out.println("delete");
        deleteParticipantApp.execute(gamertag);

        return "redirect:/";
    }
}
