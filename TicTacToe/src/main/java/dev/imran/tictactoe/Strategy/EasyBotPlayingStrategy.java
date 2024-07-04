package dev.imran.tictactoe.Strategy;

import dev.imran.tictactoe.Models.Board;
import dev.imran.tictactoe.Models.Cell;
import dev.imran.tictactoe.Models.CellState;
import dev.imran.tictactoe.Models.Move;

import java.util.List;

public class EasyBotPlayingStrategy implements BotPlayingStrategy{


    @Override
    public Move MakeMove(Board board) {
        for(List<Cell> row : board.getBoard()){
            for(Cell cell : row){
                if(cell.getCellState().equals(CellState.EMPTY)){
                    return new Move(cell,null);
                }
            }
        }
        return null;
    }
}
