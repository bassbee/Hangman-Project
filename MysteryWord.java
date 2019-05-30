import pkg.*;
import java.util.ArrayList;
public class MysteryWord{
	private ArrayList<String> words;
	private boolean[] guess;
	private String mWord;
	private String hint;
	private ArrayList<String> fails;
	
	public MysteryWord(String difficulty){
		EasyReader read = new EasyReader("words/" + difficulty.toLowerCase() + ".txt");
		words = new ArrayList<String>();
		while(!read.eof()) //add all words from the txt into the words array
		{
			words.add(read.readLine());
		}
		fails = new ArrayList<String>();
		
		// if(difficulty.equals("HARD")){       	//the following is all commented out for testing
		// 	read = new EasyReader("words/hard.txt");
		// }else if(difficulty.equals("MEDIUM")){
		// 	read = new EasyReader("words/medium.txt");
		// }else{
		// 	read = new EasyReader("words/easy.txt");
		// }
		
		// while(!read.eof())
		// {
		// 	words.add(read.readLine());
		// }
		// mWord = words.get((int)(Math.random()*words.size()));
		mWord = words.get((int)(Math.random() * words.size()));    //this is the returned mystery word the player has to guess. for testing
		hint = "";
		for(int i=0;i<mWord.length();i++) hint += "_";   // prints string of underscores
		guess = new boolean[mWord.length()];
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
			if(mWord.substring(i,i+1).equals(input)) 
			{
				guess[i] = true;

			}
		}
		if(mWord.indexOf(input) == -1) fails.add(input);
	}

	public void printGameStatus()
	{
		for(int i=0;i<mWord.length();i++)  // prints out the game status.
		{
			if(guess[i]) System.out.print(mWord.substring(i,i+1)+" ");
			else System.out.print(hint.substring(i,i+1)+" ");
		}
		System.out.print("       |        Incorrect Guesses: "+fails);
		System.out.println();
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
