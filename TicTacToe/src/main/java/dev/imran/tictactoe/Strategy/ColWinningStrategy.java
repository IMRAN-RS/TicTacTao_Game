package dev.imran.tictactoe.Strategy;

import dev.imran.tictactoe.Models.Board;
import dev.imran.tictactoe.Models.Move;
import dev.imran.tictactoe.Models.Symbol;

import java.util.HashMap;
import java.util.Map;

public class ColWinningStrategy implements WinningStrategy {

    private Map<Integer,Map<Symbol,Integer>> counts = new HashMap<>();


    @Override
    public boolean CheckWinning(Board board, Move move) {
        return false;
    }

    @Override
    public void handleUndo(Board board, Move move) {
        int col = move.getCell().getCol();
        Symbol symbol = move.getPlayer().getSymbol();

        Map<Symbol,Integer> colMap = counts.get(col);
        colMap.put(symbol,colMap.get(symbol) - 1);
    }

    @Override
    public boolean CheckWinner(Board board, Move move) {
        int col = move.getCell().getCol();
        Symbol symbol = move.getPlayer().getSymbol();
        if(!counts.containsKey(col)){
            counts.put(col, new HashMap<>());
        }
        Map<Symbol, Integer> colMap = counts.get(col);
        colMap.put(symbol, colMap.getOrDefault(symbol, 0) + 1);

        // Assuming the board size is 3 for a standard Tic-Tac-Toe game
        // and the number of symbols in a column required to win is also 3
        return colMap.get(symbol) == board.getSize();
    }
}
