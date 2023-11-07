import java.awt.Color;

import acm.graphics.*;
import acm.program.GraphicsProgram;

public class GraphicsSample extends GraphicsProgram {
	private static final int PAUSE_MS = 20;
	private static final int VEL_X = 3;

	public void run() {
		GRect myRect = new GRect(100, 200);
		myRect.setFilled(true);
		add(myRect, 100, 150);
		
		myRect.setColor(Color.RED);
		pause(PAUSE_MS); //pause works in ConsoleProgram too
		myRect.setColor(Color.BLUE);
		
//		myRect.setLocation(10, 10);
//		myRect.move(10, 10);
		
		int finalX = 200;
		int vx = VEL_X;
		int vy = 0;
		
		// != won't work sometimes 
		while(myRect.getX() <= finalX - vx) {
			myRect.move(vx, vy);
			pause(PAUSE_MS); 
		}

	}

	private void staticGraphics() {

//		add(new GRect(100, 200), 100, 150);
//		add(new GOval(100, 200), 100, 150);

		GRect myRect = new GRect(100, 200);
		add(myRect, 100, 150);

//		GRect secondRect = new GRect(100, 200);
//		add(secondRect, 300, 150);

//		myRect.setFilled(true);

		GRect oldRect = myRect;
		myRect = new GRect(100, 200);
		add(myRect, 100, 250);

		myRect.setFilled(true);
		oldRect.setFilled(true);
		oldRect.setColor(Color.GREEN);

		int x = getWidth() / 2;
		add(oldRect, x, x);

	}
}
