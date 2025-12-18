package com.ccc.tournament.shared.NotificationEmail.domain.service;

import com.tournament.tournament.NotificationEmail.application.port.outh.LoadTournamentPort;
import com.tournament.tournament.NotificationEmail.domain.model.Tournament;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;
import java.util.List;

@Service
public class NotificationSchedulerService {

    private final LoadTournamentPort loadTournamentPort;
    private final JavaMailSender emailSender;

    public NotificationSchedulerService(LoadTournamentPort loadTournamentPort, JavaMailSender emailSender) {
        this.loadTournamentPort = loadTournamentPort;
        this.emailSender = emailSender;
    }

    // Ejecuta cada minuto
    @Scheduled(cron = "0 * * * * *")
    public void checkAndNotifyTournaments() {
        LocalDateTime now = LocalDateTime.now();
        // Buscamos torneos que empiecen entre dentro de 60 minutos y 61 minutos
        // (para evitar enviar doble o perder alguno por segundos)
        LocalDateTime startWindow = now.plusMinutes(60).truncatedTo(ChronoUnit.MINUTES);
        LocalDateTime endWindow = startWindow.plusMinutes(1);

        List<Tournament> upcomingTournaments = loadTournamentPort.findTournamentsStartingIn(startWindow, endWindow);

        for (Tournament tournament : upcomingTournaments) {
            notifyParticipants(tournament);
        }
    }

    private void notifyParticipants(Tournament tournament) {
        if (tournament.participants() == null || tournament.participants().isEmpty()) {
            return;
        }

        for (var player : tournament.participants()) {
            if (player.email() != null && !player.email().isEmpty()) {
                sendEmail(player.email(), tournament.name());
            }
        }
    }

    private void sendEmail(String to, String tournamentName) {
        try {
            SimpleMailMessage message = new SimpleMailMessage();
            message.setTo(to);
            message.setSubject("Recordatorio de Torneo: " + tournamentName);
            message.setText("Hola,\n\nTu torneo '" + tournamentName
                    + "' comienza en 1 hora. ¡Prepárate!\n\nSaludos,\nEl equipo.");
            emailSender.send(message);
            System.out.println("Email enviado a " + to + " para torneo " + tournamentName);
        } catch (Exception e) {
            System.err.println("Error enviando email a " + to + ": " + e.getMessage());
        }
    }
}
