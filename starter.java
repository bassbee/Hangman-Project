/*
C:\Users\SNAK2761\Desktop\hw second semester\hw 7 with output\hw 7>java -cp .; starter
The word has 5 letters.
 Guess the word (all caps)
AAAAA
+A+A+
guess the word again:
MASAP
*A*A+
guess the word again:
PATAE
+A*A*
guess the word again:
APPAL
++PA*
guess the word again:
PAPAL
+APA*
guess the word again:
NAPAL
+APA*
guess the word again:
JAPAN
You win

C:\Users\SNAK2761\Desktop\hw second semester\hw 7 with output\hw 7>pause
Press any key to continue . . .
*/
import pkg.*;
import java.util.ArrayList;
public class starter
{
	public static void main(String args[])
	{	
		// please leave following line alone, necessary for keyboard input
		// put code here
		String[] a = {"PACIFIC", "ATLANTIC", "ARCTIC", "CANADA", "JAPAN", "BRAZIL", "ARGENTINA", "AUSTRALIA"};
		GameState g = new GuessWordGame(a);
		ArrayList<String> ar = g.getCurrentMoves();
		GameDriver game = new GameDriver(g);
		game.play();
	}
}
