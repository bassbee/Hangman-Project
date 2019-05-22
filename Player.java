import pkg.*;
import java.util.ArrayList;
public class Player
{
	private String name;

	public Player(String aname){
		name = aname;
	}
	public String getName(){
		return name;
	}
	public String getNextMove(GameState state){
		ArrayList<String> moves = state.getCurrentMoves();
		return moves.get(0);
		
	}

}
