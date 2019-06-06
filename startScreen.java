import java.awt.*;
import java.awt.event.*;
import java.awt.geom.*;
import javax.swing.*;

/**
 *	THIS IS A TEST.
 *	not sure if we should create this class or implement gui code inside HangmanGame.java.	
 *  (Buttons: choose the level of difficulty of game)
 **/
public class startScreen extends JFrame
{
	JPanel gameTitlePanel, buttonsPanel;
	JLabel gameTitle;
	Font gameTitleFont = new Font("Bebas Neue", Font.PLAIN, 170);
	
	JButton ez, med, hard;
	
	public startScreen()
	{
		/**Creating frame (basically a NFrame)**/
		super("Hangman");
		setVisible(true);
		setSize(500,500); //default size
		setExtendedState(JFrame.MAXIMIZED_BOTH); //set to fullscreen
		setResizable(true); //resize the screen
		setDefaultCloseOperation(EXIT_ON_CLOSE); 
		// getContentPane().setBackground(Color.black); //frame background color
		setLayout(null); //doesn't resize contents of the screen when you resize the screen
		
		/**Create a Panel for the game title**/
		gameTitlePanel = new JPanel();
		gameTitlePanel.setBounds(200,100, 1100, 200); //set panel size
		gameTitlePanel.setBackground(new Color(214, 0, 67)); //set panel color
		
		/**Create the title of the game**/
		gameTitle = new JLabel("Save Dr. Neat");
		gameTitle.setForeground(Color.white); //letters' color
		gameTitle.setFont(gameTitleFont); 
		this.add(gameTitlePanel); //add title to panel
		gameTitlePanel.add(gameTitle); //add panel to frame
		
		/**BUTTONS**/
		buttonsPanel = new JPanel();
		buttonsPanel.setBounds(400, 500, 100, 100);
		buttonsPanel.setBackground(new Color(214, 0, 67));
		

		ez = new JButton("easy");
		ez.addActionListener((ActionEvent e) -> {
			/**add what happens when 'easy' is pressed*/
			System.out.println("easy");
			HangmanGame game = new HangmanGame();
			game.setDifficulty("easy");
			game.drawGame();
		});
		
		med = new JButton("medium");
		med.addActionListener((ActionEvent e) -> {
			/**add what happens when 'medium' is pressed*/
			System.out.println("medium");
			HangmanGame game = new HangmanGame();
			game.setDifficulty("medium");
			game.drawGame();
			
		});
		
		hard = new JButton("hard");
		hard.addActionListener((ActionEvent e) -> {
			/**add what happens when 'hard' is pressed*/
			System.out.println("hard");
			HangmanGame game = new HangmanGame();
			game.setDifficulty("hard");
			game.drawGame();
		});
		
		buttonsPanel.add(ez, BorderLayout.CENTER); buttonsPanel.add(med); buttonsPanel.add(hard); //add buttons to panel
		// ez.setBackground(Color.black); ez.setForeground(Color.white); 
		this.add(buttonsPanel, BorderLayout.CENTER); //add panel to frame
		
	}
	
	// private String press()
	// {
		// return "";
	// }
	
	public static void main(String args[])
	{
		startScreen test = new startScreen();
	}
}