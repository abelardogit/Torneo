package com.ccc.tournament.dashboard.participantsCrud.UpdateParticipant.application;

import com.ccc.tournament.dashboard.participantsCrud.CreateNewParticipant.application.NewParticipantRequest;
import com.ccc.tournament.dashboard.participantsCrud.UpdateParticipant.domain.UpdateParticipantService;
import com.ccc.tournament.shared.domain.Participant;
import org.springframework.stereotype.Component;

@Component
public class UpdateParticipantApp {

    private final UpdateParticipantService updateParticipantService;

    public UpdateParticipantApp(UpdateParticipantService updateParticipantService) {
        this.updateParticipantService = updateParticipantService;
    }

    public Participant execute(String originalGamertag, NewParticipantRequest request) {
        return updateParticipantService.execute(originalGamertag, request);
    }
}
