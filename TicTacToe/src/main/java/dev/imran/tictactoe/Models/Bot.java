package dev.imran.tictactoe.Models;


import dev.imran.tictactoe.Strategy.BotPlayingStrategy;
import dev.imran.tictactoe.Strategy.BotPlayingStrategyFactory;

public class Bot extends Player{

    private BotDifficultyLevel botDifficultyLevel;
    private BotPlayingStrategy botPlayingStrategy;




    public BotPlayingStrategy getBotPlayingStrategy() {
        return botPlayingStrategy;
    }




    public Bot( Long id,String playerName, Symbol symbol,
                             BotDifficultyLevel botDifficultyLevel) {
        super( id,playerName, symbol, PlayerType.BOT);
        this.botDifficultyLevel = botDifficultyLevel;
        this.botPlayingStrategy = BotPlayingStrategyFactory
                .getBotPlayingStrategy(botDifficultyLevel);
    }

    public BotDifficultyLevel getBotDifficultyLevel() {
        return botDifficultyLevel;
    }

    public void setBotDifficultyLevel(BotDifficultyLevel botDifficultyLevel) {
        this.botDifficultyLevel = botDifficultyLevel;
    }

    @Override
    public Move MakeMove(Board board) {
        // TODO: make the makeMove method in strategy accept player instead of
        // setting it here
        Move move = botPlayingStrategy.MakeMove(board);
        move.setPlayer(this);
        return move;
    }
}
