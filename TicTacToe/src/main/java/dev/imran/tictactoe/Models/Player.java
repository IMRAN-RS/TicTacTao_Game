package dev.imran.tictactoe.Models;



import java.util.Scanner;
public class Player {

    private String playerName;

    private Long id;

    private Symbol symbol;

    private PlayerType playerType;

    private Scanner scanner;

//    TODO : Write ID Generation Logic

    public Player( Long id,String playerName, Symbol symbol, PlayerType playerType) {

        this.id = id;
        this.playerName = playerName;
        this.symbol = symbol;
        this.playerType = playerType;
        this.scanner = new Scanner(System.in);
    }
    public Symbol getSymbol() {
        return symbol;
    }

    public void setSymbol(Symbol symbol) {
        this.symbol = symbol;
    }

    public PlayerType getPlayerType() {
        return playerType;
    }

    public void setPlayerType(PlayerType playerType) {
        this.playerType = playerType;
    }

    public String getPlayerName() {
        return playerName;
    }

    public void setPlayerName(String playerName) {
        this.playerName = playerName;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Move MakeMove(Board board) {
        System.out.println("Please give the row where you want to " +
                "make the move (0 based index)");
        int row = scanner.nextInt();

        System.out.println("Please give the col where you want to " +
                "make the move (0 based index)");

        int col = scanner.nextInt();

        return new Move(new Cell(row, col), this);
    }
}
