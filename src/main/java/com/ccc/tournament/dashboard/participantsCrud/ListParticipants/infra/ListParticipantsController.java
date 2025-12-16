package com.ccc.tournament.dashboard.participantsCrud.ListParticipants.infra;

import com.ccc.tournament.dashboard.participantsCrud.ListParticipants.application.ListParticipantsApp;
import com.ccc.tournament.shared.domain.Participant;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/participantes")
public class ListParticipantsController {

    private final ListParticipantsApp listParticipantsApp;

    public ListParticipantsController(ListParticipantsApp listParticipantsApp) {
        this.listParticipantsApp = listParticipantsApp;
    }

    @GetMapping
    public List<Participant> list() {
        return listParticipantsApp.findAll();
    }

    @GetMapping("/{gamertag}")
    public ResponseEntity<Participant> get(@PathVariable String gamertag) {
        return listParticipantsApp.findByGamertag(gamertag)
                .map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.notFound().build());
    }
}
