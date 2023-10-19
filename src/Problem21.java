//21. ხაზებით ბადის დახატვა 10x10 ზე

import acm.graphics.*;
import acm.program.GraphicsProgram;

public class Problem21 extends GraphicsProgram{
	private static final int NUM_LINES = 11;
	public void run() {
		for(int i = 0; i < NUM_LINES; i++) {
			addVerticalLine(i);
			addHorisontalLine(i);
		}
	}
	
//	y = 0 , height , height + height ....
	private void addHorisontalLine(int i) {
		double height = (double)getHeight() / (NUM_LINES - 1);
		double y = i * height;
		double x1 = 0;
		double x2 = getWidth();
		
		GLine line = new GLine(x1, y, x2, y);
		add(line);	
	}
	
	private void addVerticalLine(int i) {
		double width = (double)getWidth() / (NUM_LINES - 1);
		double x = i * width;
		double y1 = 0;
		double y2 = getHeight();
		
		GLine line = new GLine(x, y1, x, y2);
		add(line);
	}
}
