package com.ccc.tournament.dashboard.participantsCrud.UpdateParticipant.domain;

import com.ccc.tournament.dashboard.participantsCrud.CreateNewParticipant.application.NewParticipantRequest;
import com.ccc.tournament.shared.domain.Participant;
import com.ccc.tournament.shared.domain.ParticipantRepository;
import org.springframework.stereotype.Service;

@Service
public class UpdateParticipantService {

    private final ParticipantRepository participantRepository;

    public UpdateParticipantService(ParticipantRepository participantRepository) {
        this.participantRepository = participantRepository;
    }

    public Participant execute(String originalGamertag, NewParticipantRequest request) {
        // Reemplaza el registro (en in-memory no existe update real)
        participantRepository.deleteByGamertag(originalGamertag);

        Participant updated = new Participant(
                request.getGamertag(),
                request.getEmail(),
                request.getGame(),
                request.getRole()
        );

        participantRepository.save(updated);
        return updated;
    }
}
