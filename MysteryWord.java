import pkg.*;
import java.util.ArrayList;
public class MysteryWord{
	ArrayList<String> words;
	
	public MysteryWord(String difficulty){
		EasyReader read;
		words = new ArrayList<String>();
		
		if(difficulty.equals("hard")){
			read = new EasyReader("words/hard.txt");
		}else if(difficulty.equals("medium")){
			read = new EasyReader("words/medium.txt");
		}else{
			read = new EasyReader("words/easy.txt");
		}
		
		while(!read.eof())
		{
			words.add(read.readLine());
		}
	}
	
	public String getWord()
	{
		return words.get((int)(Math.random()*words.size()));
	}
	
	public void print()
	{
		System.out.println("word list: ");
		for(String s : words)
		{
			System.out.println(s);
		}
	}
	
	public static void main(String args[])
	{
		MysteryWord test = new MysteryWord("hard");
		System.out.println(test.getWord());
		test.print();
		
	}

}