package e04;

import java.util.Random;

public class DiceGameV2 {
    private int currentPlayer;
    private int winner = -1;
    private int[] playerScores = {0, 0};
    
    public DiceGameV2(Random rng) {
    	this.currentPlayer = rng.nextInt(1, 3);
    }

    public void rollDice(Random rng) {
        int diceRoll = rng.nextInt(1, 7);
        if (currentPlayer == 1) {
            playerScores[0] += diceRoll;
        } else {
        	playerScores[1] += diceRoll;
        }
    }
    
    public void setPlayer() {
    	currentPlayer = currentPlayer == 1 ? 2 : 1;
    }

    public int getCurrentPlayer() {
        return currentPlayer;
    }

    public int getPlayerScore(int player) {
    	player = player - 1;
        return playerScores[player];
    }
    
    public int getWinner() {
    	return this.winner;
    }
    
    public void play(Random rng) {
    	while(winner == -1) {
    		rollDice(rng);
    		if (getPlayerScore(currentPlayer) > 60) {
            	winner = currentPlayer;
            	break;
            }
    		setPlayer();
    	}
    	System.out.println("Player " + currentPlayer + " has won!");
    	
    }
    
}
