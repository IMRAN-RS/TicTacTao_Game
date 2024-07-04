package dev.imran.tictactoe;

import dev.imran.tictactoe.Controller.GameController;
import dev.imran.tictactoe.Exceptions.BotCountMoreThanOneException;
import dev.imran.tictactoe.Exceptions.DuplicateSymbolException;
import dev.imran.tictactoe.Exceptions.PlayerCountMismatchException;
import dev.imran.tictactoe.Models.*;
import dev.imran.tictactoe.Strategy.ColWinningStrategy;
import dev.imran.tictactoe.Strategy.DiagWinningStrategy;
import dev.imran.tictactoe.Strategy.RowWinningStrategy;
import dev.imran.tictactoe.Strategy.WinningStrategy;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws BotCountMoreThanOneException, DuplicateSymbolException, PlayerCountMismatchException {

        GameController gameController = new GameController();
        Scanner scanner = new Scanner(System.in);
        int dimension = 3;
        List<Player> players = new ArrayList<>();
        players.add(
                new Player(1L, "Mohammed", new Symbol('X'), PlayerType.HUMAN)
        );
        players.add(new Bot(2L,"Imran", new Symbol('0'), BotDifficultyLevel.EASY));

        List<WinningStrategy> winningStrategies = List.of(
                new RowWinningStrategy(),
                new ColWinningStrategy(),
                new DiagWinningStrategy()
        );
               Game game = gameController.StartGame(
                       players,dimension,winningStrategies
               );
        while(gameController.CheckState(game).equals(GameState.IN_PROGRESS)){
            gameController.PrintBoard(game);

            System.out.println("Does anyone want to undo? (y/n)");
            String undoAnswer = scanner.next();

            if(undoAnswer.equalsIgnoreCase("y")) {
                gameController.Undo(game);
                continue;
            }

            gameController.MakeMove(game);
        }
        System.out.println("Game is finished");
        GameState gameState = gameController.CheckState(game);

        if(gameState == GameState.DRAW) {
            System.out.println("Game has drawn");
        } else if(gameState == GameState.WIN) {
            System.out.println(gameController.GetWinner(game).getPlayerName() + " won the game.");
        }
    }
}