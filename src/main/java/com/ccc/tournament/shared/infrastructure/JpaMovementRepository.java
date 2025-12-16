package com.ccc.tournament.shared.infrastructure;

import com.ccc.tournament.shared.domain.Game;
import com.ccc.tournament.shared.domain.GameRepository;
import org.springframework.data.jpa.repository.JpaRepository;

public interface JpaMovementRepository extends JpaRepository<Game, Long>, GameRepository {

}
