package com.ccc.tournament.dashboard.participantsCrud.ListParticipants.domain;

import com.ccc.tournament.shared.domain.Participant;
import com.ccc.tournament.shared.domain.ParticipantRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ListParticipantsService {

    private final ParticipantRepository participantRepository;

    public ListParticipantsService(ParticipantRepository participantRepository) {
        this.participantRepository = participantRepository;
    }

    public List<Participant> findAll() {
        return participantRepository.findAll();
    }

    public Optional<Participant> findByGamertag(String gamertag) {
        return participantRepository.findByGamertag(gamertag);
    }
}
