import pkg.*;
import java.util.ArrayList;
public class GuessWordGame implements GameState{
	String[] words;
	String userInput, answerString;
	MysteryWord answer;
	Player player;
	EasyReader reader;
	public GuessWordGame(String[] ws){
		words = ws;
		answerString = getRandomAnswerString();
		answer = new MysteryWord(answerString);
		player = new Player("You");
		reader = new EasyReader();
		System.out.println("The word has " + answerString.length() + " letters. \n Guess the word (all caps)");
		userInput = reader.readWord();
	}
	private String getRandomAnswerString(){
		int i = (int)(Math.random()*words.length);
		return words[i];
	}
	public boolean isGameOver(){
		if(userInput.equals(answerString)){
			return true;
		}
		return false;
	}
	public Player getWinner(){
		return player;
	}
	public Player getCurrentPlayer(){
		return player;
	}
	public ArrayList<String> getCurrentMoves(){
		ArrayList<String> returnThis = new ArrayList<String>();
		returnThis.add(answer.getHint(userInput));
		return returnThis;
	}
	//updates game to reflect effect of move
	public void makeMove(String move){
		System.out.println("guess the word again: " );
		userInput = reader.readWord();
	}
	public String toString(){
		return "this is the toString";
	}
	public String getAnswer(){
		return answerString;
	}

}