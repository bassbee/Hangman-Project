import pkg.*;
import java.util.ArrayList;
public class MysteryWord{
	String word, output;
	String[] correct;
	public MysteryWord(String w){
		word = w;
		correct = makeLetters(word);
		output = "";
	}
	
	private String[] makeLetters(String in){
		String[] letters = new String[in.length()];
		for(int x = 0; x < in.length(); x++){
			letters[x] = in.substring(x, x+1);
		}
		return letters;
	}

	public String getOutput(){
		return output;
	}
	public String getAnswer(){
		return word;
	}
	public int length(){
		return word.length();
	}
	public String toString(){
		return word;
	}
}