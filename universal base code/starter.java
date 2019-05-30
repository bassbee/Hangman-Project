import pkg.*;
import java.util.ArrayList;

public class starter
{
        public static void main(String args[])
        {
			ArrayList<Rectangle> parts = new ArrayList<Rectangle>();
			Picture drNeato = new Picture("neatwhole.png");
			
			Picture theNuse = new Picture("nuse.png");
			theNuse.grow(100,100);
			theNuse.translate(100,100);
			theNuse.draw();
			System.out.println("X: "+theNuse.getX());
			System.out.println("Y: "+theNuse.getY());
			
			drNeato.grow(-1100,-1050);
			drNeato.translate(-1050,-1000);
			
			System.out.println("x: "+drNeato.getX());
			System.out.println("y: "+drNeato.getY());
			System.out.println(drNeato.getWidth() + " " + drNeato.getHeight());
			drNeato.draw();
			
			int x = 100;
			Rectangle arm1 = new Rectangle(45,110,140,40);
			Rectangle arm2 = new Rectangle(260,105,140,50);
			Rectangle body = new Rectangle(185,105,75,145);
			Rectangle head = new Rectangle(195,50,45,55);
			Rectangle leg1 = new Rectangle(185,250,40,165);
            Rectangle leg2 = new Rectangle(225,250,40,165);
			
			arm1.setColor(Color.WHITE);
			arm2.setColor(Color.WHITE);
			body.setColor(Color.WHITE);
			head.setColor(Color.WHITE);
			leg1.setColor(Color.WHITE);
			leg2.setColor(Color.WHITE);
			
			parts.add(arm1);
			parts.add(arm2);
			parts.add(body);
			parts.add(head);
			parts.add(leg1);
			parts.add(leg2);
			
			arm1.fill();
			arm2.fill();
			body.fill();
			head.fill();
			leg1.fill();
			leg2.fill();
		}
	
}
