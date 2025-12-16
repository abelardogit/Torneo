package com.ccc.tournament.dashboard.participantsCrud.CreateNewParticipant.infra;

import com.ccc.tournament.dashboard.participantsCrud.CreateNewParticipant.application.CreateNewParticipantApp;
import com.ccc.tournament.dashboard.participantsCrud.CreateNewParticipant.application.NewParticipantRequest;
import com.ccc.tournament.shared.domain.Participant;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/participantes")
public class CreateNewParticipantController {

    private final CreateNewParticipantApp createNewParticipantApp;

    public CreateNewParticipantController(CreateNewParticipantApp createNewParticipantApp) {
        this.createNewParticipantApp = createNewParticipantApp;
    }

    // REST: POST /participantes
    @PostMapping
    public ResponseEntity<Participant> create(@RequestBody NewParticipantRequest request) {
        Participant created = createNewParticipantApp.execute(request);
        return ResponseEntity.status(HttpStatus.CREATED).body(created);
    }

    // Alias para compatibilidad con tu HTML anterior: POST /participantes/create
    @PostMapping("/create")
    public ResponseEntity<Participant> createLegacy(@RequestBody NewParticipantRequest request) {
        Participant created = createNewParticipantApp.execute(request);
        return ResponseEntity.status(HttpStatus.CREATED).body(created);
    }
}
