import pkg.*;
import java.util.ArrayList;
public class GameDriver //Sarah's code. this works; no editing pls.
{
	private GameState state;
	private Text condition;
	
	public GameDriver(GameState initial){
		state = initial;
	}
	public void play(){
		
		while(!(state.isGameOver())){
			Player currentPlayer = state.getCurrentPlayer();
			String nextMove = currentPlayer.getNextMove(state);
			state.makeMove(nextMove);
		}
		if(!(state.getWinner() == null)){
			// condition = new Text(200,450,state.getWinner().getName() + " win");
			// condition.grow(30,10);
			// condition.draw();
			
			/*gui*/
			Hangman.gui.result(true);
		}
		else{
			// System.out.println("you lose"); 
			// condition = new Text(200,450,"you lose");
			// condition.grow(30,10);
			// condition.draw();
			
			/*gui*/
			Hangman.gui.result(false);
		}
	}
	
}
