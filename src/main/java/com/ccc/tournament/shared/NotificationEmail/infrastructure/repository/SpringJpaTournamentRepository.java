package com.ccc.tournament.shared.NotificationEmail.infrastructure.repository;

import com.tournament.tournament.NotificationEmail.infrastructure.entity.TournamentEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import java.time.LocalDateTime;
import java.util.List;

public interface SpringJpaTournamentRepository extends JpaRepository<TournamentEntity, Long> {
    List<TournamentEntity> findByStartDatetimeGreaterThanEqualAndStartDatetimeLessThan(LocalDateTime startWindow,
            LocalDateTime endWindow);
}
