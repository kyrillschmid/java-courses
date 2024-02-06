package e04;

import java.util.Random;

public class DiceGame {
    private int currentPlayer;
    private int winner = -1;
    private int[] playerScores = {0, 0};
    
    public DiceGame() {
    	this.currentPlayer = new Random().nextInt(1, 3);
    }

    public void rollDice() {
        int diceRoll = new Random().nextInt(1, 7);
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
    
    public void play() {
    	while(winner == -1) {
    		rollDice();
    		if (getPlayerScore(currentPlayer) > 60) {
            	winner = currentPlayer;
            	break;
            }
    		setPlayer();
    	}
    	System.out.println("Player " + currentPlayer + " has won!");
    	
    }
    
}

