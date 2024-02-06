package e04;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.Random;

import org.junit.jupiter.api.Test;


public class BetterDiceGameTest {
	
/*	private DiceGameV2 game;
	private static final int SEED_PLAYER_ONE_STARTS = 1337;
	private static final int SEED_PLAYER_TWO_STARTS = 42;
	private static final int SEED_PLAYER_ONE_WINS = 2;
	private static final int SEED_PLAYER_TWO_WINS = 42;
	
	
    @Test
    public void testRollDiceCurrentPlayerIsPlayerOne() {
    	Random rng = new Random(SEED_PLAYER_ONE_STARTS); // Player 1 starts
		game = new DiceGameV2(rng);
        game.rollDice(rng);
        assertTrue(game.getPlayerScore(game.getCurrentPlayer()) >= 1 && game.getPlayerScore(game.getCurrentPlayer()) <= 6);
    }
    
    @Test
    public void testRollDiceCurrentPlayerIsPlayerTwo() {
    	Random rng = new Random(SEED_PLAYER_TWO_STARTS); // Player 2 starts
    	game = new DiceGameV2(rng);
        game.rollDice(rng);
        assertTrue(game.getPlayerScore(game.getCurrentPlayer()) >= 1 && game.getPlayerScore(game.getCurrentPlayer()) <= 6);
    }

    @Test
    public void testTurnsCurrentPlayerIsPlayerOne() {
    	Random rng = new Random(SEED_PLAYER_ONE_STARTS); // Player 1 starts
    	game = new DiceGameV2(rng);
        game.setPlayer();
        assertEquals(game.getCurrentPlayer(), 2);
    }

    @Test
    public void testTurnsCurrentPlayerIsPlayerTwo() {
    	Random rng = new Random(SEED_PLAYER_TWO_STARTS); // Player 2 starts
        game = new DiceGameV2(rng);
        game.setPlayer();
        assertEquals(game.getCurrentPlayer(), 1);
    }
    
    @Test
    public void testFinalPlayerAssumingPlayerOneWins() {
    	Random rng = new Random(SEED_PLAYER_ONE_WINS); // Player 1 wins
    	game = new DiceGameV2(rng);
    	game.play(rng);
    	assertTrue(game.getCurrentPlayer() == 1);
    }
    
    @Test
    public void testFinalPlayerAssumingPlayerTwoWins() {
    	Random rng = new Random(SEED_PLAYER_TWO_WINS);
    	game = new DiceGameV2(rng);
    	game.play(rng);
    	assertTrue(game.getCurrentPlayer() == 2);
    }*/
    
   
}