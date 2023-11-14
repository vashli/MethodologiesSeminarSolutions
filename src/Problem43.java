//43. წრეწირის drag ით გადაადგილება

import java.awt.event.MouseEvent;
import acm.graphics.*;
import acm.program.GraphicsProgram;

public class Problem43 extends GraphicsProgram {
	private static final int RADIUS = 50;
	private GObject lastPressedObj;
	private int prevX;
	private int prevY;
	
	public void run() {
		GOval circle = new GOval(2 * RADIUS, 2 * RADIUS);
		circle.setFilled(true);
		add(circle, getWidth() / 2 - RADIUS, getHeight() / 2 - RADIUS);
		addMouseListeners();
	}
	
	public void mousePressed(MouseEvent e) {
		GObject obj = getElementAt(e.getX(), e.getY());
		lastPressedObj = obj;
		if(obj != null) {
			// update values
			prevX = e.getX();
			prevY = e.getY();
		}
	}
	
	public void mouseDragged(MouseEvent e) {
		if(lastPressedObj != null) {
			// move object
			lastPressedObj.move(e.getX() - prevX, e.getY() - prevY);
			// update values
			prevX = e.getX();
			prevY = e.getY();
		}
	}

}

//// this version has a bug when we move the mouse too fast
////43. წრეწირის drag ით გადაადგილება
//import java.awt.event.MouseEvent;
//import acm.graphics.*;
//import acm.program.GraphicsProgram;
//
//public class Problem43 extends GraphicsProgram{
//	private static final int RADIUS = 50;
//	private int prevX;
//	private int prevY;
//	
//	public void run() {
//		GOval circle = new GOval(2 * RADIUS, 2 * RADIUS);
//		circle.setFilled(true);
//		add(circle, getWidth() / 2 - RADIUS, getHeight() / 2 - RADIUS);
//		addMouseListeners();
//	}
//	
//	@Override
//	public void mousePressed(MouseEvent e) {
//		GObject obj = getElementAt(e.getX(), e.getY());
//		if(obj != null) {
//			prevX = e.getX();
//			prevY = e.getY();
//		}
//	}
//	
//	@Override
//	public void mouseDragged(MouseEvent e) {
//		GObject obj = getElementAt(e.getX(), e.getY());
//		if(obj != null) {
//			
//			// move
//			obj.move(e.getX() - prevX, e.getY() - prevY);
//			
//			// update prev values
//			prevX = e.getX();
//			prevY = e.getY();
//		}
//	}
//}	
//
