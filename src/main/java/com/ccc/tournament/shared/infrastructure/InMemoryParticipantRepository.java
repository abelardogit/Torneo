package com.ccc.tournament.shared.infrastructure;

import com.ccc.tournament.shared.domain.Participant;
import com.ccc.tournament.shared.domain.ParticipantRepository;
import org.springframework.stereotype.Repository;

import java.util.*;

@Repository
public class InMemoryParticipantRepository implements ParticipantRepository {

    private final List<Participant> participants = new ArrayList<>();

    @Override
    public void save(Participant participant) {
        deleteByGamertag(participant.getGamertag());
        participants.add(participant);

        System.out.println("[InMemoryParticipantRepository] Guardado participante: "
                + participant.getGamertag() + " - " + participant.getEmail());
    }

    @Override
    public List<Participant> findAll() {
        return Collections.unmodifiableList(participants);
    }

    @Override
    public Optional<Participant> findByGamertag(String gamertag) {
        return participants.stream()
                .filter(p -> p.getGamertag().equals(gamertag))
                .findFirst();
    }

    @Override
    public void deleteByGamertag(String gamertag) {
        Iterator<Participant> iterator = participants.iterator();
        while (iterator.hasNext()) {
            Participant p = iterator.next();
            if (p.getGamertag().equals(gamertag)) {
                iterator.remove();
                System.out.println("[InMemoryParticipantRepository] Eliminado participante: " + gamertag);
                break; // solo borra el primero que coincida
            }
        }
    }
}
