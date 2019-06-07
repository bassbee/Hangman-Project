/*
Note:
I still need to add the keyboard and mouse listener
so it will accept user input.
** IMPORTANT **
I need help figuring out how to combine this with our gamestate,
gamedriver, and hangman game to make a fully functional game.
Would appreciate if anyone helped.
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

import pkg.Text;

package HangmanGUIwip;

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
	private JLabel word;
	
	public HangmanGUI() {
		display = new JPanel();
		JButton hit = new JButton("Guess?");
		JTextField input = new JTextField("");
	 	
		ImageIcon pic = createImageIcon("images/neatwhole.png","whole neat");
		// Scales image
		Image img = pic.getImage();
		Image newImg = img.getScaledInstance(300,300,java.awt.Image.SCALE_SMOOTH);
		pic = new ImageIcon(newImg);
		JLabel neato = new JLabel(pic);
		  neato.setVisible(false);
		JLabel guess = new JLabel("Tries: ");
		
		  word = new JLabel("");
		  word.setBounds(10,25,100,30);
		  word.setVisible(false);
		  display.add(word);
		
		
		hit.setBounds(210, 420, 100, 30);
		display.setBounds(800, 800, 200, 100);
		neato.setBounds(0,0,500,400);
		guess.setBounds(180,25,100,30);
		input.setBounds(195,380,130,25);
		 
		display.add(hit); //Add to JFrame
		display.add(neato);
		display.add(guess);
		display.add(input);
		display.setLayout(null); // JPanel layout
		add(display);
		
		
		 /**
		  * Action Performed when button is pressed.
		  */
		  hit.addActionListener(new ActionListener() {
          public void actionPerformed(ActionEvent e) {
            /*Add what happens when the button is pressed*/
			System.out.println("hit");
			neato.setVisible(true);
          }
	      } );
		
		
		// JFrame properties
        setSize(500,500);
        setBackground(Color.WHITE);
        setTitle("Dr. Neato Hangman");
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
    }
	
	//ADD TO GAMEDRIVER CONSTRUCTOR!
	
	public void addWord(String s)
	{
		// JLabel guess = new JLabel(s);
		// display.add(guess);
		// guess.setBounds(10,25,100,30);
		word.setText(s);
		word.setVisible(true);
	}
}
