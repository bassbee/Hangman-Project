import pkg.*;
import java.util.ArrayList;
public class MysteryWord{
	private ArrayList<String> words;
	private boolean[] guess;
	private String mWord;
	private String hint;
	private ArrayList<String> fails;
	private Text tries;
	private Text actual;
	private String actualStr;
	// Neato drNeat;
	
	public MysteryWord(String difficulty){
		EasyReader read = new EasyReader("words/" + difficulty.toLowerCase() + ".txt");
		words = new ArrayList<String>();
		while(!read.eof()) //add all words from the txt into the words array
		{
			words.add(read.readLine());
		}
		fails = new ArrayList<String>();
		mWord = words.get((int)(Math.random() * words.size()));    //this is the returned mystery word the player has to guess. for testing
		hint = "";
		for(int i=0;i<mWord.length();i++) hint += "_";   // prints string of underscores
		guess = new boolean[mWord.length()];
		
		// drNeat = new Neato();
		
		// tries = new Text(160,25,"Letters you've used: "+fails.toString());
		// tries.grow(45,10);
		// tries.draw();
		
		actualStr = new String("");
		for(int i=0;i<mWord.length();i++)  // draws game status onscreen.
		{
			if(guess[i]) actualStr += mWord.substring(i,i+1)+" ";
			else actualStr += hint.substring(i,i+1)+" ";
		}
		// actual = new Text(200,420,actualStr);
		// actual.grow(20,10);
		// actual.draw();
		
		/*gui*/
		Hangman.gui.updateWord(hint); //add the hints in gui
	}
	
	public String getWord()
	{
		return mWord;
	}

	public String getNewWord()
	{
		return words.get((int)(Math.random()*words.size()));
	}

	public void updateGame(String input)
	{
		for(int i=0;i<mWord.length();i++)
		{
			if(mWord.substring(i,i+1).equals(input.toLowerCase())) 
			{
				guess[i] = true;
			}
		}
		
		/*
		 * check for duplicates
		*/
		boolean duplicate = false;
		for(int i = 0; i< fails.size(); i++)
		{
			if(input.toLowerCase().equals(fails.get(i).toLowerCase())) duplicate = true;
		}
		
		if(!duplicate && mWord.indexOf(input.toLowerCase()) == -1){
			fails.add(input.toLowerCase());
			// drNeat.getPart(fails.size()-1); //add a part of DrNeat's body
			
			/*gui*/
			Hangman.gui.updateFails(input, fails.size()); //update screen in gui
		}
			
	}

	public void printGameStatus()
	{
		// for(int i=0;i<mWord.length();i++)  //// prints out the game status.
		// {
			// if(guess[i]) System.out.print(mWord.substring(i,i+1)+" ");
			// else System.out.print(hint.substring(i,i+1)+" ");
		// }
		// System.out.print("       |        Incorrect Guesses: "+fails);
		// System.out.println();
		// tries.setText("Letters you've used: "+fails);
		
		actualStr = "";
		for(int i=0;i<mWord.length();i++)  // updates and draws game status onscreen.
		{
			if(guess[i]) actualStr += mWord.substring(i,i+1)+" ";
			else actualStr += hint.substring(i,i+1)+" ";
		}
		// actual.setText(actualStr);
		
		/*gui*/
		Hangman.gui.updateWord(actualStr);
	}

	public boolean wordComplete()
	{
		for(boolean b:guess) if(!b) return b;
		return true;
	}

	public boolean noLivesLeft()
	{
		return fails.size() == 6;
	}

	public ArrayList<String> getWordList()
	{
		return words;
	}
	
	public String toString()
	{
		return mWord;
	}

}
