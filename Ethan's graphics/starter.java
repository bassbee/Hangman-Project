import pkg.*;
import java.util.ArrayList;

public class starter
{
        public static void main(String args[])
        {
			ArrayList<Rectangle> parts = new ArrayList<Rectangle>();
			Picture drNeato = new Picture("neatwhole.png");
			
			drNeato.grow(-1100,-1050);
			drNeato.translate(-1050,-1000);
			drNeato.draw();
			
			Rectangle arm1 = new Rectangle(45,110,140,40);
			Rectangle arm2 = new Rectangle(260,105,140,50);
			Rectangle body = new Rectangle(185,105,75,145);
			Rectangle head = new Rectangle(195,50,45,55);
			Rectangle leg1 = new Rectangle(185,250,40,165);
            Rectangle leg2 = new Rectangle(225,250,40,165);
			
			arm1.fill();
			arm1.setColor(Color.WHITE);
			arm2.fill();
			arm2.setColor(Color.WHITE);
			body.fill();
			body.setColor(Color.WHITE);
			head.fill();
			head.setColor(Color.WHITE);
			leg1.fill();
			leg1.setColor(Color.WHITE);
			leg2.fill();
			leg2.setColor(Color.WHITE);
			
			parts.add(head);
			parts.add(body);
			parts.add(arm1);
			parts.add(arm2);
			parts.add(leg1);
			parts.add(leg2);
			
			EasyReader input = new EasyReader();
			int wrongGuesses = 0;
			while(wrongGuesses<parts.size())
			{
				if(input.readWord().equals("s"))
				{
					System.out.print("You win!");
					break;
				}
				else
				{
					System.out.println("Wrong");
					parts.get(wrongGuesses).translate(-1000,0);
					wrongGuesses++;
				}
			}
			if(wrongGuesses==parts.size())
				System.out.print("Game Over. Neato is dead");
		}
	
}