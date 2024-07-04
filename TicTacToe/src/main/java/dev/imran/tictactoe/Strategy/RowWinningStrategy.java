package dev.imran.tictactoe.Strategy;

import dev.imran.tictactoe.Models.Board;
import dev.imran.tictactoe.Models.Move;
import dev.imran.tictactoe.Models.Symbol;

import java.util.HashMap;
import java.util.Map;

public  class RowWinningStrategy implements WinningStrategy {

    private Map<Integer,Map<Symbol,Integer>> counts = new HashMap<>();

    @Override
    public boolean CheckWinner(Board board, Move move) {
        int row = move.getCell().getRow();
        Symbol symbol = move.getPlayer().getSymbol();

        // Flaw in logic. Fix it.

        Map<Symbol,Integer> rowMap = counts.getOrDefault(row, new HashMap<>());
        rowMap.put(symbol,rowMap.getOrDefault(symbol,0) + 1);
        return rowMap.get(symbol) == board.getSize();
    }


    @Override
    public boolean CheckWinning(Board board, Move move) {
        return false;
    }

    @Override
    public void handleUndo(Board board, Move move){
        int row = move.getCell().getRow();
        Symbol symbol = move.getPlayer().getSymbol();

        Map<Symbol,Integer> rowMap = counts.get(row);
        rowMap.put(symbol,rowMap.getOrDefault(symbol,0) - 1);
    }
}
