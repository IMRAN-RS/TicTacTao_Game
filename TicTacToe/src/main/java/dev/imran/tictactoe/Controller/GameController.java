package dev.imran.tictactoe.Controller;

import dev.imran.tictactoe.Exceptions.BotCountMoreThanOneException;
import dev.imran.tictactoe.Exceptions.DuplicateSymbolException;
import dev.imran.tictactoe.Exceptions.PlayerCountMismatchException;
import dev.imran.tictactoe.Models.Game;
import dev.imran.tictactoe.Models.GameState;
import dev.imran.tictactoe.Models.Player;
import dev.imran.tictactoe.Strategy.WinningStrategy;

import java.util.List;

public class GameController {

    public Game StartGame(List<Player> players, int boardDimensions,
                           List<WinningStrategy> winningStrategies) throws BotCountMoreThanOneException, DuplicateSymbolException, PlayerCountMismatchException {

        return Game.getBuilder()
                .setPlayers(players)
                .setWinningStrategies(winningStrategies)
                .setSize(boardDimensions)
                .build();

    }

    public void MakeMove(Game game) {
            game.MakeMove();
    }

    public GameState CheckState(Game game){

        return game.getGameState();
    }

    public Player GetWinner(Game game){
           return game.getWinner();
    }

    public void PrintBoard(Game game){
         game.PrintBoard();

    }

    public void Undo(Game game){
        game.Undo();
    }

}
