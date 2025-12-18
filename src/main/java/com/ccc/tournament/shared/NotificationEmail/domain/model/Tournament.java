package com.ccc.tournament.shared.NotificationEmail.domain.model;

import java.time.LocalDateTime;
import java.util.List;

public record Tournament(
        Long id,
        String name,
        LocalDateTime startDatetime,
        List<User> participants) {
}
