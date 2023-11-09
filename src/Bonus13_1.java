import acm.graphics.GLine;
import acm.program.GraphicsProgram;

public class Bonus13_1 extends GraphicsProgram {
	public void run() {
//		version1();
//		version2();
		version3();
	}

	private void version1() {
		while (true) {
			removeAll();
			GLine line = new GLine(0, getHeight() / 2, getWidth(), getHeight() / 2);
			add(line);
			pause(20);
		}
	}

	private void version2() {
		GLine line = new GLine(0, getHeight() / 2, getWidth(), getHeight() / 2);
		add(line);

		while (true) {
			remove(line);
			line = new GLine(0, getHeight() / 2, getWidth(), getHeight() / 2);
			add(line);
			pause(20);
		}
	}

	private void version3() {
		GLine line = new GLine(0, getHeight() / 2, getWidth(), getHeight() / 2);
		add(line);

		while (true) {
			line.setStartPoint(0, getHeight() / 2);
			line.setEndPoint(getWidth(), getHeight() / 2);
			pause(20);
		}
	}

}
