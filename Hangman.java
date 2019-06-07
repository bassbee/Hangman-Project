import pkg.*;
import java.util.ArrayList;

// import HangmanGUIwip.HangmanGUI;

class Hangman implements GameState
{
	private MysteryWord mWord; //mysteryword that returns the word player needs to guess
	private Player player;     //the player
	private EasyReader console;// how the console receives guesses and difficulty

	/*variables for HangmanGUI.java*/
	static HangmanGUI gui;
	static String input; //used in line 65
	
	public Hangman()
	{
		gui = new HangmanGUI(); //setVisible false
		//after lines 17-21, in mysteryWord set the game
		
		System.out.print("Choose HARD/MEDIUM/EASY: ");
		console = new EasyReader();     //easyreader gets the difficulty from the console. 
		String d = console.readLine();  //on our final project, the canvas will do this instead.
		mWord = new MysteryWord(d.toLowerCase());     //REMEMBER, d = difficulty, not the actual word. 
		player = new Player("User");
		
		// System.out.println("[Enter in a letter to guess!] \n\n");
		// mWord.printGameStatus();
		
		input = "";
		gui.init();
	}
	
	public boolean isGameOver()
	{
		if(!mWord.noLivesLeft()) return mWord.wordComplete(); // checks if the player has failed three times OR
								      //if he has guessed the word
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
		if(move.equals("guess")) //only valid move is guess. so thats what we worry about
		{
			// mWord.updateGame(console.readChar()+"");
			mWord.printGameStatus();
			
			/*gui*/
			mWord.updateGame(input);
		}
		else return;
	}

	public String toString() //no tostring yet
	{
		return "this is toString";
	}
}
