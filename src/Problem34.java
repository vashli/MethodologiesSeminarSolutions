import java.awt.Color;

import acm.graphics.GOval;
import acm.program.GraphicsProgram;
import acm.util.RandomGenerator;

//34. კანვასზე დახატეთ 1000 შემთხვევითი რადიუსის მქონე შემთხვევითი ფერით
//გაფერადებული წრე, შემთხვევით კოორდინატებზე.
public class Problem34 extends GraphicsProgram{
	public void run(){
		int maxN = 1000;
		// we create random generator object only once use is as an argument for functions
		RandomGenerator rgen = new RandomGenerator();
		for (int i = 0; i < maxN; i++){
			drawRandomCircle(rgen);
		}
	}

	private void drawRandomCircle(RandomGenerator rgen) {
		int radius = rgen.nextInt(10, 20);
		double x = rgen.nextDouble(0, getWidth() - 2 * radius);
		double y = rgen.nextDouble(0, getHeight() - 2 * radius);
		
		Color color = rgen.nextColor();
		
		GOval circle = new GOval(x, y, 2 * radius, 2 * radius);
		circle.setFilled(true);
		circle.setColor(color);
		add(circle);
	}

}
