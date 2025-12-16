package com.ccc.tournament.dashboard.participantsCrud.DeleteParticipant.application;

import com.ccc.tournament.dashboard.participantsCrud.DeleteParticipant.domain.DeleteParticipantService;
import org.springframework.stereotype.Component;

@Component
public class DeleteParticipantApp {
    private final DeleteParticipantService deleteParticipantService;

    public DeleteParticipantApp(DeleteParticipantService deleteParticipantService) {
        this.deleteParticipantService = deleteParticipantService;

    }
    public void execute(String gamertag) {
        deleteParticipantService.execute(gamertag);
    }
}
