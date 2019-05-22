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
	public String getHint(String in){
		String[] input = makeLetters(in);
		String returnThis = new String("");
		
		for(int x = 0; x < input.length; x++){
			if(input[x].equals(correct[x])){
				returnThis = returnThis.concat(input[x]);
			}
			else if(isContainedInCorrect(input[x])){
				returnThis = returnThis.concat("+");
			}
			else{
				returnThis = returnThis.concat("*");
			}
		}
		output = returnThis;
		return returnThis;
	}
	private String[] makeLetters(String in){
		String[] letters = new String[in.length()];
		for(int x = 0; x < in.length(); x++){
			letters[x] = in.substring(x, x+1);
		}
		return letters;
	}
	private boolean isContainedInCorrect(String letter){
		for(String l: correct){
			if(l.equals(letter)){
				return true;
			}
		}
		return false;
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