package com.devsuperior.dslist.controllers;

import com.devsuperior.dslist.dto.GameListDTO;
import com.devsuperior.dslist.dto.GameMinDTO;
import com.devsuperior.dslist.dto.ReplacementDTO;
import com.devsuperior.dslist.services.GameListService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/lists")
public class GameListController {

    private final GameListService gameListService;

    public GameListController(GameListService gameListService) {
        this.gameListService = gameListService;
    }

    @GetMapping
    public List<GameListDTO> findAllListOfGame() {
        return gameListService.findAllListOfGame();
    }

    @GetMapping(value = "/{listId}/games")
    public List<GameMinDTO> findByList(@PathVariable Long listId) {
        return gameListService.findByList(listId);
    }

    @PostMapping(value = "/{listId}/replacement")
    public void moveGame(@PathVariable Long listId, @RequestBody ReplacementDTO replacementDTO) {
        gameListService.move(listId, replacementDTO.getOriginIndex(), replacementDTO.getDestinationIndex());
    }
}
