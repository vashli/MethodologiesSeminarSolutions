//თქვენ უნდა დაწეროთ გრაფიკული პროგრამა, რომელშიც დახატავთ
//BALL_COUNT ცალ შემთხვევითი რადიუსის მქონე შავ ბურთს.(რადიუსის
//შესაძლო მნიშვნელობა უნდა იცვლებოდეს MIN_RADIUS და MAX_RADIUS-ს
//შორის). ბურთები განთავსებული უნდა იყოს შემთხვევით კოორდინატებზე ისე,
//რომ ყველა ბურთი მთლიანად ხვდებოდეს კანვასზე. თუ მაუსით დავაკლიკებთ
//რომელიმე ბურთზე, მან უნდა შეიცვალოს ფერი რაიმე შემთხვევით ფერზე. თუ
//დავაკლიკებთ ცარიელ ადგილას, მაშინ ბურთმა, რომელსაც ბოლოს
//დავაკლიკეთ(ასეთის არსებობის შემთხვევაში), უნდა დაიწყოს ვარდნა ქვემოთ
//V_Y სიჩქარით. ახალ ბურთზე როდესაც დავაკლიკებთ, ძველმა ბურთმა უნდა
//შეწყვიტოს მოძრაობა(ახალმა არ უნდა დაიწყოს მოძრაობა მანამ სანამ ისევ არ
//დავაკლიკებთ ცარიელს ადგილას). თუ კლიკი ხდება იგივე ბურთზე, რაზეც
//ბოლოს, არაფერი არ უნდა შეიცვალოს.
//ამოხსნა დაწერეთ random.java ფაილში
import java.awt.event.MouseEvent;

import acm.graphics.*;
import acm.program.GraphicsProgram;
import acm.util.RandomGenerator;

public class Midterm2023Session1RandomCircleFall extends GraphicsProgram{
	private static final int BALL_COUNT = 20;
	private static final int MIN_RADIUS = 10;
	private static final int MAX_RADIUS = 30;
	private static final int V_Y = 3;
	private static final int DELAY = 100;
	
	private GOval circle = null;
	private int vy = 0;
	private RandomGenerator rgen = RandomGenerator.getInstance();
	
	public void run() {
		addRandomCircles();
		addMouseListeners();
		
		while(true) {
			if (circle != null) {
				circle.move(0, vy);
			}
			pause(DELAY);
		}
	}
	
	private void addRandomCircles() {
		for (int i = 0; i < BALL_COUNT; i++) {
			int radius = rgen.nextInt(MIN_RADIUS, MAX_RADIUS);
			GOval circle = new GOval(radius, radius);
			int x = rgen.nextInt(0, getWidth() - 2 * radius);
			int y = rgen.nextInt(0, getHeight() - 2 * radius);
			circle.setFilled(true);
			add(circle, x, y);
		}
	}
	
	@Override
	public void mouseClicked(MouseEvent e) {
		GObject o = getElementAt(e.getX(), e.getY());
		if (o != null  && o != circle) {
			o.setColor(rgen.nextColor());
			circle = (GOval) o;
			vy = 0;
		}else {
			vy = V_Y;
		}
	}

}
