package com.ccc.tournament.dashboard.participantsCrud.CreateNewParticipant.domain.service;

import com.ccc.tournament.dashboard.participantsCrud.CreateNewParticipant.application.NewParticipantRequest;
import com.ccc.tournament.shared.domain.Participant;
import com.ccc.tournament.shared.domain.ParticipantRepository;
import org.springframework.stereotype.Service;

@Service
public class CreateNewParticipantService {

    private final ParticipantRepository participantRepository;

    public CreateNewParticipantService(ParticipantRepository participantRepository) {
        this.participantRepository = participantRepository;
    }

    public Participant execute(NewParticipantRequest request) {
        Participant participant = new Participant(
                request.getGamertag(),
                request.getEmail(),
                request.getGame(),
                request.getRole()
        );

        participantRepository.save(participant);
        return participant;
    }
}