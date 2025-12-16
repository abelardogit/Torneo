package com.ccc.tournament.dashboard.gamescrud.updategame.infrastructure.controller;

import com.ccc.tournament.dashboard.gamescrud.updategame.application.UpdateGameApp;
import com.ccc.tournament.dashboard.gamescrud.updategame.application.UpdateGameRequest;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

@RestController
public class UpdateGameController {

    private final UpdateGameApp updateGameApp;
    private final com.ccc.tournament.shared.storagefiles.domain.interfaces.StorageService storageService;

    public UpdateGameController(UpdateGameApp updateGameApp, com.ccc.tournament.shared.storagefiles.domain.interfaces.StorageService storageService) {
        this.updateGameApp = updateGameApp;
        this.storageService = storageService;
    }

    @PostMapping("/game/update/{id}")
    public void updateGame(@PathVariable Long id,
                           @ModelAttribute UpdateGameRequest request,
                           @RequestParam(value = "bannerFile", required = false) MultipartFile bannerFile,
                           @RequestParam(value = "cardFile", required = false) MultipartFile cardFile) {

        if (bannerFile != null && !bannerFile.isEmpty()) {
            storageService.store(bannerFile);
            request.setBannerImage(bannerFile.getOriginalFilename());
        }
        if (cardFile != null && !cardFile.isEmpty()) {
            storageService.store(cardFile);
            request.setCardImage(cardFile.getOriginalFilename());
        }
        updateGameApp.execute(id, request);
    }
}