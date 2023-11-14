import java.awt.Color;
import java.awt.event.KeyEvent;
import java.awt.event.MouseEvent;

import acm.graphics.*;
//import acm.graphics.GRect;
import acm.program.GraphicsProgram;

public class GraphicsEventsSample extends GraphicsProgram {
//	GRect rect = new GRect(100, 100);
	private GRect rect;
	private GRect rect2;
	private GLabel label;

	public void init() {
//		GRect rect = new GRect(100, 100); // creates local variable instead of initializing our instance variable
		rect = new GRect(100, 100);
		rect.setFilled(true);
		add(rect);

//		GRect rect2 = new GRect(100, 100);
		rect2 = new GRect(100, 100);
		rect2.setFilled(true);
		add(rect2, 200, 200);

		label = new GLabel("waiting for a key");

		add(label, getWidth() / 2, getHeight() / 2);
		addMouseListeners();
		addKeyListeners();
	}

	public void run() {
		GOval movingBall = new GOval(50, 50);
		movingBall.setFilled(true);
		movingBall.setColor(Color.CYAN);
		add(movingBall, getWidth() / 2, 0);
		int vy = 3;
		while (true) {
			if (movingBall.getY() > getHeight() - movingBall.getHeight() || movingBall.getY() < 0) {
				vy = -vy;
			}
			movingBall.move(0, vy);
			pause(20);
		}
	}

	private void tst() {
		System.out.println("tst");
	}

	@Override
	public void mouseClicked(MouseEvent e) {
		// can be used for debugging code, don't leave it in final programs
		System.out.println("clicked: " + e.getX() + " " + e.getY());

		tst(); // you can call your private methods from listener methods

		// returns object if clicked on one, or null if clicked on an empty space
		GObject obj = getElementAt(e.getX(), e.getY());

//		// standard code to check if clicked an object
//		if(obj != null) {
//			obj.setColor(Color.RED);
//		}

		if (obj != null && obj.getColor() != Color.BLACK) {
			obj.setColor(Color.BLACK);
		} else if (obj == rect) {
			obj.setColor(Color.RED);
		} else if (obj == rect2) {
			obj.setColor(Color.BLUE);
		}
	}

	@Override
	public void keyTyped(KeyEvent e) {
		System.out.println("typed: " + e.getKeyChar()); // prints in console
		label.setLabel("key typed: " + e.getKeyChar());
		
//		if (e.getKeyChar() == 'h') {
//			
//		}
		
//		if(e.getKeyCode() == KeyEvent.VK_SPACE) {
//			
//		}
	}
}
