//კანვასზე რენდომ ადგილას დახატეთ რენდომ რადიუსის რენდომ ფერით გაფერადებული 
//წრეწირი. როდესაც წრეწირს მაუსს დავაქლიქებთ მან რენდომ სიჩქარით რენდომ 
//მიმართულებით უნდა დაიწყოს მოძრაობა და რენდომ ფერით გაფერადსეს წრეწირი. 
//(ყოველ ახალ ქლიქზე სიჩქარე  და ფერი რენდომად უნდა იცვლებოდეს). 
//კედლებთან შეჯახებისას ბურთი უნდა ისხლიტებოდეს.
//

import java.awt.event.MouseEvent;

import acm.graphics.GObject;
import acm.graphics.GOval;
import acm.program.GraphicsProgram;
import acm.util.RandomGenerator;

public class Bonus20_1 extends GraphicsProgram {
	private static final double RADIUS_MIN = 10;
	private static final double RADIUS_MAX = 50;
	private static final int V_MIN = 1;
	private static final int V_MAX = 5;
	private static final int DELAY = 100;

	private RandomGenerator rgen = RandomGenerator.getInstance();
	private GOval circle = null;
	private int vx = 0;
	private int vy = 0;

	public void run() {
		addMouseListeners();
		addRandomCircle();

		// this version works every time
		while (true) {
			if (circle.getX() < 0) {
				vx = Math.abs(vx);
			} else if (circle.getX() > getWidth() - circle.getWidth()) {
				vx = -Math.abs(vx);
			}
			if (circle.getY() < 0) {
				vy = Math.abs(vy);
			} else if (circle.getY() > getHeight() - circle.getHeight()) {
				vy = -Math.abs(vy);
			}
			
			// this works almost every time, has a small bug in this case because of random speed at every click
//			if (circle.getX() < 0 || circle.getX() > getWidth() - circle.getWidth()) {
//				vx = -vx;
//			}
//			if (circle.getY() < 0 || circle.getY() > getHeight() - circle.getHeight()) {
//				vy = -vy;
//			}

			circle.move(vx, vy);
			pause(DELAY);
		}

	}

	private void addRandomCircle() {
		double radius = rgen.nextDouble(RADIUS_MIN, RADIUS_MAX);
		circle = new GOval(2 * radius, 2 * radius);
		circle.setFilled(true);
		circle.setColor(rgen.nextColor());
		double x = rgen.nextDouble(0, getWidth() - 2 * radius);
		double y = rgen.nextDouble(0, getHeight() - 2 * radius);
		add(circle, x, y);
	}

	@Override
	public void mouseClicked(MouseEvent e) {
		GObject obj = getElementAt(e.getX(), e.getY());
		if (obj != null) {
			vx = getRandomSpeed();
			vy = getRandomSpeed();
			circle.setColor(rgen.nextColor());

		}
	}

	private int getRandomSpeed() {
		int v = rgen.nextInt(V_MIN, V_MAX);
		boolean negSpeed = rgen.nextBoolean();
		if (negSpeed) {
			v = -v;
		}
		return v;
	}
}
