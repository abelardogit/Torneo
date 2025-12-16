package com.ccc.tournament.dashboard.participantsCrud.DeleteParticipant.domain;

import com.ccc.tournament.shared.domain.ParticipantRepository;
import org.springframework.stereotype.Service;

@Service
public class DeleteParticipantService {

    private final ParticipantRepository participantRepository;

    public DeleteParticipantService(ParticipantRepository participantRepository) {
        this.participantRepository = participantRepository;
    }

    public void execute(String gamertag) {
        participantRepository.deleteByGamertag(gamertag);
    }
}
