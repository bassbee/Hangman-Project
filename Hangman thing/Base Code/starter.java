import pkg.*;
public class starter
{
        public static void main(String args[])
        {
			Picture head = new Picture("drneathead.png");
			Picture body = new Picture("drneatbody.png");
			Picture larm = new Picture("drneatleftarm.png");
			Picture rarm = new Picture("drneatrightarm.png");
			Picture lleg = new Picture("drneatleftleg.png");
			Picture rleg = new Picture("drneatrightleg.png");
		
			Picture[] neato = {head, body, larm, rarm, lleg, rleg};
		
			EasyReader letterInput = new EasyReader();
			System.out.println("Guess a letter");
			int i = 0;
			for(int a = 0; a<neato.length; a++)
			{
				neato[a].grow(-170,-170);
				neato[a].draw();
			}
			
			//neato[i].grow(-170,-170);
			//neato[i].draw();
		
		}
	
}