package dev.imran.tictactoe.Strategy;

import dev.imran.tictactoe.Models.Board;
import dev.imran.tictactoe.Models.Move;

public interface WinningStrategy {

    boolean CheckWinning(Board board, Move move);

    void handleUndo(Board board, Move move);


    boolean CheckWinner(Board board, Move move);
}
