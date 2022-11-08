import java.awt.event.MouseEvent;

import acm.graphics.GOval;
import acm.graphics.GPolygon;
import acm.program.GraphicsProgram;

//41. გააკეთეთ Paint-ის ფანქრის ანალოგიური ხელსაწყო. კერძოდ, მაუსის ყოველ მოძრაობაზე
//ეკრანზე დაამატეთ გაფერადებული წრეწირები იმავე წერტილში სადაც მაუსი მდებარეობს.
public class Problem41 extends GraphicsProgram {
	private static int RADIUS = 5;
	private int prevX;
	private int prevY;
	
	public void init() {
		addMouseListeners();
	}

	public void mouseDragged(MouseEvent e) {
		GOval dot = new GOval(2 * RADIUS, 2 * RADIUS);
		dot.setFilled(true);
		add(dot, e.getX() - RADIUS, e.getY() - RADIUS);
		
		// for the smoother transition while moving the mouse too fast
		add(fillerPolygon(prevX, prevY, e.getX(), e.getY()));
		prevX = e.getX();
		prevY = e.getY();
	}

	public void mousePressed(MouseEvent e) {
		GOval dot = new GOval(2 * RADIUS, 2 * RADIUS);
		dot.setFilled(true);
		add(dot, e.getX() - RADIUS, e.getY() - RADIUS);
		
		// for the smoother transition while moving the mouse too fast
		prevX = e.getX();
		prevY = e.getY();
	}

	// for the smoother transition while moving the mouse too fast
	private GPolygon fillerPolygon(int x1, int y1, int x2, int y2) {
		GPolygon p = new GPolygon();
		p.setFilled(true);
		double x = Math.abs(x2 - x1);
		double y = Math.abs(y2 - y1);
		double z = Math.sqrt(Math.pow(x,2) + Math.pow(y, 2));
		double dx = RADIUS * y / z;
		double dy = RADIUS * x / z;
		if((x1 >= x2 && y1 >= y2) || (x1 <= x2 && y1 <= y2)){
			p.addVertex(x1 + dx, y1 - dy);
			p.addVertex(x1 - dx, y1 + dy);
			p.addVertex(x2 - dx, y2 + dy);
			p.addVertex(x2 + dx, y2 - dy);
		}else{
			p.addVertex(x1 + dx, y1 + dy);
			p.addVertex(x1 - dx, y1 - dy);
			p.addVertex(x2 - dx, y2 - dy);
			p.addVertex(x2 + dx, y2 + dy);
		}
		return p;
	}
}
