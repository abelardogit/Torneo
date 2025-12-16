package com.ccc.tournament.dashboard.participantsCrud.UpdateParticipant.infra;

import com.ccc.tournament.dashboard.participantsCrud.CreateNewParticipant.application.NewParticipantRequest;
import com.ccc.tournament.dashboard.participantsCrud.UpdateParticipant.application.UpdateParticipantApp;
import com.ccc.tournament.shared.domain.Participant;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/participantes")
public class UpdateParticipantController {

    private final UpdateParticipantApp updateParticipantApp;

    public UpdateParticipantController(UpdateParticipantApp updateParticipantApp) {
        this.updateParticipantApp = updateParticipantApp;
    }

    // REST: PUT /participantes/{originalGamertag}
    @PutMapping("/{originalGamertag}")
    public ResponseEntity<Participant> update(@PathVariable String originalGamertag,
                                              @RequestBody NewParticipantRequest request) {
        Participant updated = updateParticipantApp.execute(originalGamertag, request);
        return ResponseEntity.ok(updated);
    }

    // Alias para compatibilidad con tu HTML anterior: POST /participantes/update?originalGamertag=...
    @PostMapping("/update")
    public ResponseEntity<Participant> updateLegacy(@RequestParam("originalGamertag") String originalGamertag,
                                                    @RequestBody NewParticipantRequest request) {
        Participant updated = updateParticipantApp.execute(originalGamertag, request);
        return ResponseEntity.ok(updated);
    }
}
