package com.ccc.tournament.dashboard.participantsCrud.ListParticipants.application;

import com.ccc.tournament.dashboard.participantsCrud.ListParticipants.domain.ListParticipantsService;
import com.ccc.tournament.shared.domain.Participant;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

@Component
public class ListParticipantsApp {

    private final ListParticipantsService listParticipantsService;

    public ListParticipantsApp(ListParticipantsService listParticipantsService) {
        this.listParticipantsService = listParticipantsService;
    }

    public List<Participant> findAll() {
        return listParticipantsService.findAll();
    }

    public Optional<Participant> findByGamertag(String gamertag) {
        return listParticipantsService.findByGamertag(gamertag);
    }
}
