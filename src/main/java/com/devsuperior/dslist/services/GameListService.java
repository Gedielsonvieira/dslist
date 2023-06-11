package com.devsuperior.dslist.services;

import com.devsuperior.dslist.dto.GameListDTO;
import com.devsuperior.dslist.dto.GameMinDTO;
import com.devsuperior.dslist.entities.GameList;
import com.devsuperior.dslist.projections.GameMinProjection;
import com.devsuperior.dslist.repositories.GameListRepository;
import com.devsuperior.dslist.repositories.GameRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class GameListService {

    private final GameListRepository gameListRepository;
    private final GameRepository gameRepository;

    public GameListService(GameListRepository gameListRepository, GameRepository gameRepository) {
        this.gameListRepository = gameListRepository;
        this.gameRepository = gameRepository;
    }

    @Transactional(readOnly = true)
    public List<GameListDTO> findAllListOfGame() {
        List<GameList> listOfGames = gameListRepository.findAll();
        return listOfGames.stream().map(x -> new GameListDTO(x)).toList();
    }

    @Transactional(readOnly = true)
    public List<GameMinDTO> findByList(Long listId) {
        List<GameMinProjection> listOfGames = gameListRepository.searchByList(listId);
        return listOfGames.stream().map(x -> new GameMinDTO(x)).toList();
    }

    @Transactional
    public void move(Long listId, int originIndex, int destinationIndex) {
        List<GameMinProjection> listOfGames = gameListRepository.searchByList(listId);

        /*
        Foi feito a remoção e inserção do jogo na lista para que assim consigamos obter as novas posições
        */
        GameMinProjection obj = listOfGames.remove(originIndex);
        listOfGames.add(destinationIndex, obj);

        int min = originIndex < destinationIndex ? originIndex : destinationIndex;
        int max = originIndex < destinationIndex ? destinationIndex : originIndex;

        for (int i = min; i <= max; i++) {
            /*
            E com as novas posições da memória atualizamos o banco de dados informando em qual
            lista vamos fazer esta modificação o id do jogo que vai sofrer a atualização e a sua nova posição
            */
            gameListRepository.updateBelongingPosition(listId, listOfGames.get(i).getId(), i);
        }
    }


}
