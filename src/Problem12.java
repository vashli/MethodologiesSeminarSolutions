import java.awt.Color;
import acm.graphics.*;
import acm.program.*;

//12. გრაფიკული პროგრამის გამოყენებით დახატეთ სახლი.
public class Problem12 extends GraphicsProgram {

	public void run() {
		drawWall();
		drawDoor();
		drawWindow();
		drawRoof();
	}

	private void drawWall() {
		int width = 180;
		int height = 220;
		int padding = 40;
		int x = (getWidth() - width)/ 2 ;
		int y = (getHeight() - height) - padding;
		GRect wall = new GRect(width, height);
		wall.setFilled(true);
		wall.setColor(Color.LIGHT_GRAY);
		add(wall, x, y);
	}
	
	private void drawDoor() {
		int width = 70;
		int height = 90;
		int padding = 40;
		int x = (getWidth() - width)/ 2 ;
		int y = (getHeight() - height) - padding;
		GRect door = new GRect(width, height);
		door.setFilled(true);
		door.setColor(Color.BLACK);
		add(door, x, y);
	}
	
	private void drawWindow() {
		int width = 50;
		int height = 70;
		int x = getWidth() / 2 + width / 2;
		int y = getHeight() - 220;
		GRect window = new GRect(width, height);
		window.setFilled(true);
		window.setColor(Color.RED);
		add(window, x, y);
	}
	
	private void drawRoof() {
		// x, y, width same as the wall
		int width = 180;
		int height = 220;
		int padding = 40;
		int x = (getWidth() - width)/ 2 ;
		int y = (getHeight() - height) - padding;

		// we use GPolygon object for the roof 
		// our polygon(triangle) needs 3 points for the vertices
		// alternatively you can use 2 GLines
		GPoint[] points = { 
				new GPoint(x, y), 
				new GPoint(x + width, y), 
				new GPoint(x + width / 2, y - 60) };
		GPolygon roof = new GPolygon(points);
		roof.setFilled(true);
		roof.setColor(Color.ORANGE);
		add(roof);
	}
}