package com.ccc.tournament.shared.NotificationEmail.application.port.outh;

import com.tournament.tournament.NotificationEmail.domain.model.Tournament;

import java.time.LocalDateTime;
import java.util.List;

public interface LoadTournamentPort {
    List<Tournament> findTournamentsStartingIn(LocalDateTime startWindow, LocalDateTime endWindow);
}
