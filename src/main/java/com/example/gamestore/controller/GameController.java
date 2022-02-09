package com.example.gamestore.controller;

import com.example.gamestore.entity.Game;
import com.example.gamestore.exception.GameException;
import com.example.gamestore.service.GameService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class GameController {
    @Autowired
    private GameService gameService;

    @GetMapping("/games/find/{name}")
    public Game getGameByName(@PathVariable String name) {
        return gameService.findGameByName(name);
    }

    @GetMapping("/games/create/{name}/{price}")
    public void createGame(@PathVariable String name, @PathVariable int price) {
        gameService.createGame(name, price);
    }

    @GetMapping("/games/delete/{name}")
    public void deleteGameByName(@PathVariable String name) throws GameException {
        gameService.deleteGame(name);
    }

    @GetMapping("/games/edit/price/{name}/{price}")
    public void editGamePriceByName(@PathVariable String name, @PathVariable int price) {
        gameService.EditPriceGame(name, price);
    }

}
