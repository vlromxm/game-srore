package com.example.gamestore.service;

import com.example.gamestore.entity.Game;
import com.example.gamestore.exception.GameException;
import com.example.gamestore.repository.GameRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigInteger;
import java.util.Optional;

@Service
public class GameService {
    @Autowired
    private GameRepository gameRepository;

    public void createGame(String name, int price) {
        var game = new Game();
        game.setName(name);
        game.setPrice(price);
        gameRepository.save(game);
    }

    public Game findGameByName(String name){
        Optional<Game> optionalGame = gameRepository.findGameByName(name);
        return optionalGame.orElseGet(() -> new Game(BigInteger.ZERO, "null", 0));
    }

    public void deleteGame(String name) throws GameException {
        var game = gameRepository.findGameByName(name);
        if(game.isPresent()){
            gameRepository.delete(game.get());
        } else throw (new GameException("Game is not found!"));
    }

    public void EditPriceGame(String name, int price) {
        var game = gameRepository.findGameByName(name).orElseThrow();
        game.setPrice(price);
        gameRepository.save(game);
    }
}
