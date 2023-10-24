import java.awt.Color;

import acm.graphics.*;
import acm.program.GraphicsProgram;

public class Bonus9_2 extends GraphicsProgram {
	public void run() {
		int x = 4;
		addPrettyLabel("x before method:" + x, 20);
		tripleNum(x);
		addPrettyLabel("x after method:" + x, 60);
		
		
		GRect rect = new GRect(50, 100, 200, 200);
		rect.setFilled(true);
		rect.setColor(Color.BLUE);
		
		addPrettyLabel("color of rect before method:" + rect.getColor(), 80);
		paintRed(rect);
		addPrettyLabel("color of rect after method:" + rect.getColor(), 120);
	}
	
	private void addPrettyLabel(String text, int y) {
		GLabel prettyLabel = new GLabel(text);
		prettyLabel.setFont("SansSerif-bold-16");
		add(prettyLabel, 0, y);
	}
	
	private void tripleNum(int x) {
		 x *= 3;
		 addPrettyLabel("x in method:" + x, 40);
	}
	
	private void paintRed(GRect rect) {
		rect.setColor(Color.RED);
		addPrettyLabel("color of rect in method:" + rect.getColor(), 100);
	}
}