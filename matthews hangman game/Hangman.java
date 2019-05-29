import pkg.*;
import java.util.ArrayList;

class Hangman implements GameState
{
	private MysteryWord mWord;
	private Player player;
	private EasyReader console;

	public Hangman()
	{
		System.out.print("Choose HARD/MEDIUM/EASY :");
		console = new EasyReader();
		String d = console.readLine();
		mWord = new MysteryWord(d);
		player = new Player("User");
		System.out.println("[Enter in a letter to guess!] \n\n");
		mWord.printGameStatus();
	}
	
	public boolean isGameOver()
	{
		if(!mWord.noLivesLeft()) return mWord.wordComplete();
		return true;
	}
	
	public Player getWinner()
	{
		if(isGameOver() && !mWord.noLivesLeft()) return player;
		else return null;
	}
	
	public Player getCurrentPlayer()
	{
		return player;
	}
	
	public ArrayList<String> getCurrentMoves()
	{
		ArrayList<String> r = new ArrayList<String>();
		r.add("guess");
		return r;
	}
	
	public void makeMove(String move)
	{
		if(move.equals("guess"))
		{
			mWord.updateGame(console.readChar()+"");
			mWord.printGameStatus();
		}
		else return;
	}

	public String toString()
	{
		return "this is toString";
	}
}
