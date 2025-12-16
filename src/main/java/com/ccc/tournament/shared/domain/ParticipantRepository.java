package com.ccc.tournament.shared.domain;

import java.util.List;
import java.util.Optional;

public interface ParticipantRepository {
    void save(Participant participant);
    List<Participant> findAll();
    Optional<Participant> findByGamertag(String gamertag);
    void deleteByGamertag(String gamertag);
}
