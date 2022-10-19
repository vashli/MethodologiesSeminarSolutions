import acm.graphics.*;
import acm.program.*;
//21. ხაზებით ბადის დახატვა 10x10 ზე

public class Problem21 extends GraphicsProgram {
	public void run(){
		for (int i = 0; i < 9; i++){
			double yCoord = (getHeight()/ 10.0) * (i + 1) ;
			drawHorisontalLine(yCoord);
		}
		for (int i = 0; i < 9; i++){
			double xCoord = (getWidth()/ 10.0) * (i + 1) ;
			drawVerticalLine(xCoord);
		}
	}

	private void drawHorisontalLine(double y) {
		double x1 = 0;
		double x2 = getWidth();
		double y1 = y;
		double y2 = y;
		
		GLine line = new GLine(x1, y1, x2, y2);
		add(line);
	}
	
	private void drawVerticalLine(double x) {
		double x1 = x;
		double x2 = x;
		double y1 = 0;
		double y2 = getHeight();
		
		GLine line = new GLine(x1, y1, x2, y2);
		add(line);
	}
}
