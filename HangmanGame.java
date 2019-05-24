public class HangmanGame {
	//implements GameState
	ArrayList<String> words;
	EasyReader reader;
	String difficulty, answer;
	public HangmanGame(){
		reader = new EasyReader();
		System.out.println("Choose your difficulty:");
		difficulty = reader.readWord();
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
		getRandWord();
	}
	public String getRandWord(){
		answer = words.get((int)(Math.random() * words.size()));
		System.out.println(answer);
		return answer;
	}

}