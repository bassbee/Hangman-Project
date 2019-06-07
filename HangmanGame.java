import java.util.ArrayList;
import pkg.*;

public class HangmanGame implements GameState{
	ArrayList<String> words;
	EasyReader read;
	String difficulty, answer;
	Player player;
	public HangmanGame(String d){
		words = new ArrayList<String>();
		difficulty = d;
		player = new Player("player");
	}
	public void initGame(){
		if(difficulty.equals("hard")){
			read = new EasyReader("words/hard.txt");
		}
		else if(difficulty.equals("medium")){
			read = new EasyReader("words/medium.txt");
		}
		else{
			read = new EasyReader("words/easy.txt");
		}
		while(!read.eof())
		{
			words.add(read.readLine());
		}
	}
	public void drawGame(){
		initGame();
		Rectangle background = new Rectangle(0, 0, 10000, 10000);
		background.setColor(Color.WHITE);
		background.fill();
		Text test = new Text(20, 20, difficulty);
		test.draw();
	}
	public String getRandWord(){
		answer = words.get((int)(Math.random() * words.size()));
		System.out.println(answer);
		return answer;
	}
	public Player getWinner(){
		return player;
	}
	public Player getCurrentPlayer(){
		return player;
	}
	public ArrayList<String> getCurrentMoves(){
		ArrayList<String> returnThis = new ArrayList<String>();
		returnThis.add("");
		return returnThis;
	}
	public void makeMove(String move){
		
	}
	public boolean isGameOver(){
		return false;
	}

}