import pkg.*;
public class starter
{
        public static void main(String args[])
        {
			Picture drNeato = new Picture("neatwhole.png");
			drNeato.grow(-1100,-1050);
			drNeato.translate(-1050,-1000);
			System.out.println(drNeato.getX());
			System.out.println(drNeato.getWidth() + " " + drNeato.getHeight());
			drNeato.draw();
		}
	
}