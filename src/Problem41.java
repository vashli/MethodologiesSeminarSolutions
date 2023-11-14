
//41. გააკეთეთ Paint-ის ფანქრის ანალოგიური ხელსაწყო. კერძოდ, მაუსის ყოველ მოძრაობაზე
//ეკრანზე დაამატეთ გაფერადებული წრეწირები იმავე წერტილში სადაც მაუსი მდებარეობს.import java.awt.event.MouseEvent;

import java.awt.event.MouseEvent;
import acm.graphics.GOval;
import acm.program.GraphicsProgram;

public class Problem41 extends GraphicsProgram {
	private static final int RADIUS = 20;

	public void run() {
		addMouseListeners();
	}

	@Override
	public void mouseDragged(MouseEvent e) {
		paintCircle(e.getX(), e.getY());
	}
	
	@Override
	public void mousePressed(MouseEvent e) {
		paintCircle(e.getX(), e.getY());
	}
	
	private void paintCircle(int centerX, int centerY) {
		GOval circle = new GOval(2 * RADIUS, 2 * RADIUS);
		circle.setFilled(true);
		add(circle, centerX - RADIUS, centerY - RADIUS);
	}
	
}
