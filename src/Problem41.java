import java.awt.event.MouseEvent;

import acm.graphics.GOval;
import acm.program.GraphicsProgram;

public class Problem41 extends GraphicsProgram{
	private static final int RADIUS = 20;
	public void run() {
		addMouseListeners();
	}
	
	@Override
	public void mouseDragged(MouseEvent e) {
		GOval circle = new GOval(2 * RADIUS, 2 * RADIUS);
		circle.setFilled(true);
		add(circle, e.getX(), e.getY());
	}
}
