import java.awt.Color;
import acm.graphics.*;
import acm.program.*;

//დახატეთ რობოტის სახე ფანჯრის ცენტრში.
public class Problem14 extends GraphicsProgram {
//	constants
	private static final int WIDTH = 200;
	private static final int HEIGHT = 300;

	private static final int EYE_WIDTH = 60;
	private static final int EYE_HEIGHT = 40;
	
	private static final int MOUTH_WIDTH = 100;
	private static final int MOUTH_HEIGHT = 40;
	
	public void run() {
		drawFace();
		drawLeftEye();
		drawRightEye();
		drawMouth();
	}

	private void drawFace() {
		GRect face = new GRect(WIDTH, HEIGHT);
		face.setFilled(true);
		face.setColor(Color.BLUE);
		int x = (getWidth() - WIDTH) / 2;
		int y = (getHeight() - HEIGHT) / 2;
		add(face, x, y);
	}
	
	private void drawLeftEye() {
		GOval eye = new GOval(EYE_WIDTH, EYE_HEIGHT);
		eye.setFilled(true);
		eye.setColor(Color.WHITE);
		int x = (getWidth() - EYE_WIDTH) / 2 - EYE_WIDTH;
		int y = (getHeight() - HEIGHT) / 2 + 2 * EYE_HEIGHT;
		add(eye, x, y);
	}
	
	private void drawRightEye() {
		GOval eye = new GOval(EYE_WIDTH, EYE_HEIGHT);
		eye.setFilled(true);
		eye.setColor(Color.WHITE);
		int x = getWidth() / 2 + EYE_WIDTH / 2;
		int y = (getHeight() - HEIGHT) / 2 + 2 * EYE_HEIGHT;
		add(eye, x, y);
	}	
	
	private void drawMouth() {
		GRect mouth = new GRect(MOUTH_WIDTH, MOUTH_HEIGHT);
		mouth.setFilled(true);
		mouth.setColor(Color.BLACK);
		int x = (getWidth() - MOUTH_WIDTH) / 2;
		int y = (getHeight() + HEIGHT / 2 - MOUTH_HEIGHT) / 2;
		add(mouth, x, y);
	}
}