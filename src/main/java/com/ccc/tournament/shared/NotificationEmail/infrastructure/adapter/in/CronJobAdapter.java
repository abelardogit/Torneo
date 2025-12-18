package com.ccc.tournament.shared.NotificationEmail.infrastructure.adapter.in;

import com.tournament.tournament.NotificationEmail.application.port.in.NotifyUpcomingTournamentsUseCase;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

@Component // Esto sí es Spring
public class CronJobAdapter {
    private final NotifyUpcomingTournamentsUseCase notificationUseCase;

    public CronJobAdapter(NotifyUpcomingTournamentsUseCase notificationUseCase) {
        this.notificationUseCase = notificationUseCase;
    }

    @Scheduled(cron = "0 * * * * *")
    public void checkTime() {
        // El adaptador solo llama al caso de uso. No tiene lógica.
        notificationUseCase.execute();
    }
}