import java.awt.event.MouseEvent;

import acm.graphics.GLine;
import acm.graphics.GObject;
import acm.graphics.GOval;
import acm.graphics.GPoint;
import acm.graphics.GPolygon;
import acm.program.GraphicsProgram;

//42. Paint-ის მონაკვეთის ხატვის გაკეთება, ჯერ აჭერ მაუსს, ფიქსირდება ერთი წვერო, მერე
//მაუსის მოძრაობისას მონაკვეთიც მოძრაობს რადგან მეორე წვერო არაა დაფიქსირებული და
//კლიკით ფიქსირდება მეორე წვეროც
public class Problem43 extends GraphicsProgram{
	private static int RADIUS = 100;
	private GOval circle;
	private GPoint prevPoint;
	
	public void init(){
		addMouseListeners(); 
	}
	
	public void run(){
		circle = new GOval(2 * RADIUS, 2 * RADIUS);
		circle.setFilled(true);
		add(circle, getWidth()/ 2 - RADIUS , getHeight()/ 2 - RADIUS );
	}
	
	public void mouseDragged(MouseEvent e){
		GObject currentObject = getElementAt(e.getX(), e.getY());
//		GObject currentObject = circle; // see what happens when you use this line instead of line 29
		if(currentObject != null){
			currentObject.move(e.getX() - prevPoint.getX(), 
					e.getY() - prevPoint.getY());
			prevPoint = new GPoint(e.getX(), e.getY());
		}
	}
	
	public void mousePressed(MouseEvent e){
		prevPoint = new GPoint(e.getX(), e.getY());
	}
}
