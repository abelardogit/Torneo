package com.ccc.tournament.dashboard.participantsCrud.CreateNewParticipant.application;

import com.ccc.tournament.dashboard.participantsCrud.CreateNewParticipant.domain.service.CreateNewParticipantService;
import com.ccc.tournament.shared.domain.Participant;
import org.springframework.stereotype.Service;

@Service
public class CreateNewParticipantApp {
    private final CreateNewParticipantService newParticipantService;

    public CreateNewParticipantApp(CreateNewParticipantService newParticipantService) {
        this.newParticipantService = newParticipantService;
    }

    public Participant execute(NewParticipantRequest request) {
        return newParticipantService.execute(request);
    }
}
