import java.awt.event.MouseEvent;

import acm.graphics.GLine;
import acm.graphics.GOval;
import acm.graphics.GPolygon;
import acm.program.GraphicsProgram;

//43. წრეწირის drag ით გადაადგილება
public class Problem42 extends GraphicsProgram{
	private static int RADIUS = 100;
	private GOval circle;
	
	public void init(){
		addMouseListeners(); 
	}
	
	public void run(){
		circle = new GOval(2 * RADIUS, 2 * RADIUS);
		circle.setFilled(true);
		add(circle, getWidth()/ 2 - RADIUS , getHeight()/ 2 - RADIUS );
	}

}
