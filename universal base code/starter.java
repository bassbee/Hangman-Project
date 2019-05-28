import pkg.*;
public class starter
{
        public static void main(String args[])
        {
			ArrayList<Rectangle> parts = new ArrayList<Rectangle>();
			Picture drNeato = new Picture("neatwhole.png");
			drNeato.grow(-1100,-1050);
			drNeato.translate(-1050,-1000);
			System.out.println(drNeato.getX());
			System.out.println(drNeato.getWidth() + " " + drNeato.getHeight());
			drNeato.draw();
			// Rectangle tester = new Rectangle(0,0,10,10);
			// tester.setColor(Color.black);
			// parts.add(tester);
		}
	
}