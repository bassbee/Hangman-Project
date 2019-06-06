import java.util.ArrayList;
import pkg.*;

public class HangmanGame {
	ArrayList<String> words;
	EasyReader read;
	String d, answer;
	public HangmanGame(){
		words = new ArrayList<String>();
	}
	public void setDifficulty(String difficulty){
		d = difficulty;
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
		Rectangle background = new Rectangle(0, 0, 10000, 10000);
		background.setColor(Color.WHITE);
		background.fill();
		Text test = new Text(20, 20, d);
		test.draw();
	}
	public String getRandWord(){
		answer = words.get((int)(Math.random() * words.size()));
		System.out.println(answer);
		return answer;
	}

}