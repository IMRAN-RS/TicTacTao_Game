package dev.imran.tictactoe.Strategy;

import dev.imran.tictactoe.Models.Board;
import dev.imran.tictactoe.Models.Move;

public interface BotPlayingStrategy {
    public Move MakeMove(Board board);
}
