package com.ccc.tournament.shared.NotificationEmail.infrastructure.adapter.outh.persistence;

import com.tournament.tournament.NotificationEmail.application.port.outh.LoadTournamentPort;
import com.tournament.tournament.NotificationEmail.domain.model.User;
import com.tournament.tournament.NotificationEmail.domain.model.Tournament;
import com.tournament.tournament.NotificationEmail.infrastructure.repository.SpringJpaTournamentRepository;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;
import java.util.List;

@Component
public class JpaTournamentAdapter implements LoadTournamentPort {

    private final SpringJpaTournamentRepository repository;

    public JpaTournamentAdapter(SpringJpaTournamentRepository repository) {
        this.repository = repository;
    }

    @Override
    @org.springframework.transaction.annotation.Transactional(readOnly = true)
    public List<Tournament> findTournamentsStartingIn(LocalDateTime start, LocalDateTime end) {
        return repository.findByStartDatetimeGreaterThanEqualAndStartDatetimeLessThan(start, end).stream()
                .map(entity -> new Tournament(
                        entity.getTournamentId(),
                        entity.getTournamentName(),
                        entity.getStartDatetime(),
                        entity.getParticipants().stream()
                                .map(p -> new User(p.getUserId(), p.getUsername(), p.getEmail()))
                                .toList()))
                .toList();
    }
}