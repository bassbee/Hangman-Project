/*
Note:
I still need to add the keyboard and mouse listener
so it will accept user input. 
** IMPORTANT **
I need help figuring out how to combine this with our gamestate,
gamedriver, and hangman game to make a fully functional game.
Would appreciate if anyone helped.
*/

/* UPDATE
Issues to be solved: 
	>Need to fix graphics in lines 77-131 (and also add nuse).
	
	>get rid of the old screen since we are using this gui now

	>when entering the last letter of the word that we need to guess,
the game end before the letter is printed.
*/
import java.awt.Color;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.ImageIcon;
import java.awt.Image;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseEvent;
import java.net.URL;
import java.util.List;
import java.util.ArrayList;

public class HangmanGUI extends JFrame // implements ActionListener
{
	protected ImageIcon createImageIcon(String path, String description) {
		java.net.URL imgURL = getClass().getResource(path);
		if (imgURL != null) {
			return new ImageIcon(imgURL, description);
		} else {
			System.out.println("Couldn't find file: " + path);
			return null;
		}
	}
	
	private JPanel display;
	private JLabel word; //word to be guessed
	private JLabel guess; //letters used
	private JLabel result; //text that shows up in the end of the game
	private JTextField input;
	
	private JLabel head, body, leftArm, rightArm, leftLeg, rightLeg;
	
	public HangmanGUI() {
		display = new JPanel();
		JButton hit = new JButton("Guess?");
		input = new JTextField("");
	 	
		ImageIcon pic = createImageIcon("images/neatwhole.png","whole neat");
		// Scales image
		Image img = pic.getImage();
		Image newImg = img.getScaledInstance(300,300,java.awt.Image.SCALE_SMOOTH);
		pic = new ImageIcon(newImg);
		
		// JLabel neato = new JLabel(pic);
		// neato.setVisible(false);
		
		/*
		 * too tired to code graphics help :(
		 * (set DEBUG to true when fixing the images)
		 * 
		*/
		  boolean DEBUG = false;
		  
		  pic = createImageIcon("images/drneathead.png","head");
		  img = pic.getImage();
		  newImg = img.getScaledInstance(60,60,java.awt.Image.SCALE_SMOOTH);
		  pic = new ImageIcon(newImg);
		  head = new JLabel(pic);
		  head.setBounds(0,0,500,200);
		  head.setVisible(DEBUG);
		  display.add(head);
		  
		  pic = createImageIcon("images/drneatbody.png","body");
		  img = pic.getImage();
		  newImg = img.getScaledInstance(60, 80,java.awt.Image.SCALE_SMOOTH);
		  pic = new ImageIcon(newImg);
		  body = new JLabel(pic);
		  body.setBounds(0,0,510,350);
		  body.setVisible(DEBUG);
		  display.add(body);
		  
		  pic = createImageIcon("images/drneatleftarm.png","left arm");
		  img = pic.getImage();
		  newImg = img.getScaledInstance(60, 80,java.awt.Image.SCALE_SMOOTH);
		  pic = new ImageIcon(newImg);
		  leftArm = new JLabel(pic);
		  leftArm.setBounds(0,0,400,400);
		  leftArm.setVisible(DEBUG);
		  display.add(leftArm);
		  
		  pic = createImageIcon("images/drneatrightarm.png","right arm");
		  img = pic.getImage();
		  newImg = img.getScaledInstance(60, 80,java.awt.Image.SCALE_SMOOTH);
		  pic = new ImageIcon(newImg);
		  rightArm = new JLabel(pic);
		  rightArm.setBounds(0,0,600,400);
		  rightArm.setVisible(DEBUG);
		  display.add(rightArm);
		  
		  
		  pic = createImageIcon("images/drneatleftleg.png","body");
		  img = pic.getImage();
		  newImg = img.getScaledInstance(60, 80,java.awt.Image.SCALE_SMOOTH);
		  pic = new ImageIcon(newImg);
		  leftLeg = new JLabel(pic);
		  leftLeg.setBounds(0,0,400,600);
		  leftLeg.setVisible(DEBUG);
		  display.add(leftLeg);
		  
		  
		  pic = createImageIcon("images/drneatrightleg.png","right leg");
		  img = pic.getImage();
		  newImg = img.getScaledInstance(60, 80,java.awt.Image.SCALE_SMOOTH);
		  pic = new ImageIcon(newImg);
		  rightLeg = new JLabel(pic);
		  rightLeg.setBounds(0,0,600,600);
		  rightLeg.setVisible(DEBUG);
		  display.add(rightLeg);
		/*end of drNeat's block of code*/
		  
		guess = new JLabel("Tries: ");
		word = new JLabel(""); word.setVisible(false);
		result = new JLabel(""); result.setVisible(false);
		
		hit.setBounds(210, 420, 100, 30);
		display.setBounds(800, 800, 200, 100);
		// neato.setBounds(0,0,500,400);
		guess.setBounds(180, 10,100,30);
		word.setBounds(10,25,100,30);
		result.setBounds(200, 12, 200, 60);
		input.setBounds(195,380,130,25);
		 
		display.add(hit); //Add to JFrame
		// display.add(neato);
		display.add(guess);
		display.add(word);
		display.add(result);
		display.add(input);
		display.setLayout(null); // JPanel layout
		add(display);
		
		/**
		 * Action Performed when button is pressed.
		*/
		hit.addActionListener(new ActionListener() {
        public void actionPerformed(ActionEvent e) {
            /*Add what happens when the button is pressed*/
			// System.out.println(input.getText());
			Hangman.input = input.getText();
			input.setText(""); //clears TextField
        }
	    } );
		
		
		// JFrame properties
        setSize(500,500);
        setBackground(Color.WHITE);
        setTitle("Dr. Neato Hangman");
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(false);
    }
	
	public void init()
	{
		this.setVisible(true);
	}
	
	public void updateWord(String s)
	{
		/*
		 * updates the String word with the mysteryWord
		 */ 
		word.setText(s);
		word.setVisible(true);
	}
	
	public void updateFails(String letter, int fails)
	{
		/*
		 * updates the String guess with the wront inputs from the user
		 */ 
		guess.setText(guess.getText() + " " + letter);
		
		switch(fails)
		{
			case 1:
				head.setVisible(true);
				break;
			case 2:
				body.setVisible(true);
				break;
			case 3:
				leftArm.setVisible(true);
				break;
			case 4:
				rightArm.setVisible(true);
				break;
			case 5:
				leftLeg.setVisible(true);
				break;
			case 6:
				rightLeg.setVisible(true);
				break;
		}
		
	}
	
	public void result(boolean b){
		/*
		 * method used in GameDriver.java after the game is over
		 */ 
		if(b){
			result.setText("You Saved Dr. Neat!");
		}else{
			result.setText("Oh no! You lost Dr. Neat!");
		}
		
		result.setVisible(true);
	}
}
