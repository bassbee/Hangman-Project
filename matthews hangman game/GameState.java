import pkg.*;
import java.util.ArrayList;
public interface GameState
{
	/** @return true the game is in an ending state; false otherwise*/
	boolean isGameOver();
	/** Precondition: isGameOver() returns true 
	* @return the player that won the game or nulI if there was no winner
	*/
	Player getWinner();
	/** Precondition: isGameOver0 returns false 
	* @return the player who is to make the next move */
	Player getCurrentPlayer();
	/** @return a list of valid moves for the current player; the size of the returned
	list is zero if there are no valid moves*/
	ArrayList<String> getCurrentMoves();
	/** Updates game state to reflect the effect of the specified move. 
	* @param move a description of the move to be made */
	void makeMove(String move);
	/** @return a string representing the current GameState */
	String toString();

		
}
