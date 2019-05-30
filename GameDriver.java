import pkg.*;
import java.util.ArrayList;
public class GameDriver //Sarah's code. this works; no editing pls.
{
	private GameState state;
	
	public GameDriver(GameState initial){
		state = initial;
	}
	public void play(){
		
		while(!(state.isGameOver())){
			Player currentPlayer = state.getCurrentPlayer();
			String nextMove = currentPlayer.getNextMove(state);
			//System.out.println(nextMove);
			//System.out.println(currentPlayer.getName() + " " + nextMove);
			state.makeMove(nextMove);
		}
		if(!(state.getWinner() == null)){
			System.out.println((state.getWinner()).getName() + " win");
		}
		else{
			System.out.println("you lose"); 
		}
	}
	
}
