package dev.imran.tictactoe.Strategy;

import dev.imran.tictactoe.Models.Board;
import dev.imran.tictactoe.Models.Move;
import dev.imran.tictactoe.Models.Symbol;

import java.util.HashMap;
import java.util.Map;

public class DiagWinningStrategy implements WinningStrategy {
    private Map<Symbol,Integer> leftDiagMap = new HashMap<>();
    private Map<Symbol,Integer> rightDiagMap = new HashMap<>();

    @Override
    public boolean CheckWinning(Board board, Move move) {
        Symbol symbol = move.getPlayer().getSymbol();
        int row = move.getCell().getRow();
        int col = move.getCell().getCol();

        // Check the logic once.
        // Left diag check

        if(row == col){
            leftDiagMap.put(symbol,leftDiagMap.getOrDefault(symbol,0) + 1);
        }
        // Right Diag check
        if(row+col == board.getSize()-1){
            rightDiagMap.put(symbol,rightDiagMap.getOrDefault(symbol,0) + 1);
        }

        if(row == col){
            if(leftDiagMap.get(symbol) == board.getSize()){
                return true;
            }
        }
        if(row + col == board.getSize()-1){
            if(rightDiagMap.get(symbol) == board.getSize()){
                return true;
            }
        }
        return false;
    }
    @Override
    public void handleUndo(Board board, Move move){
        Symbol symbol = move.getPlayer().getSymbol();
        int row = move.getCell().getRow();
        int col = move.getCell().getCol();
        if(row == col){
            leftDiagMap.put(symbol,leftDiagMap.getOrDefault(symbol,0) - 1);
        }
        if(row+col == board.getSize()-1){
            rightDiagMap.put(symbol,rightDiagMap.getOrDefault(symbol,0) - 1);
        }
    }

    @Override
    public boolean CheckWinner(Board board, Move move) {
        return false;
    }

}
