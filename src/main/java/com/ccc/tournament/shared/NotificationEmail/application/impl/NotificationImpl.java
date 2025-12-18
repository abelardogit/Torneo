package com.ccc.tournament.shared.NotificationEmail.application.impl;

import com.tournament.tournament.NotificationEmail.application.port.in.NotifyUpcomingTournamentsUseCase;
import com.tournament.tournament.NotificationEmail.domain.service.NotificationSchedulerService;
import org.springframework.stereotype.Service;

@Service
public class NotificationImpl implements NotifyUpcomingTournamentsUseCase {
    private final NotificationSchedulerService notificationService;

    public NotificationImpl(NotificationSchedulerService notificationService) {
        this.notificationService = notificationService;
    }

    @Override
    public void execute() {
        notificationService.checkAndNotifyTournaments();
    }
}
