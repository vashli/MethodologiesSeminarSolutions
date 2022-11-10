import java.awt.event.KeyEvent;
import java.awt.event.MouseEvent;
import acm.graphics.*;
import acm.program.GraphicsProgram;
import acm.util.RandomGenerator;

//43B. გრაფიკულ პროგრამაში დახატეთ 2 ფიგურა: მართკუთხედი და ოვალი, ორივე იყოს შევსებული.
//თუ მაუსს დავაჭერთ რომელიმე ფიგურას და გავაკეთებთ დრაგს, ფიგურაც უნდა მოძრაობდეს 
//მანამ სანამ მაუსს ხელს არ ავუშვებთ. თუ ხელს დავაჭერთ კლავიატურის რომელიმე ღილაკს, 
//ბოლოს გამოძრავებული ფიგურა უნდა გაფერადდეს რანდომ ფერით.

public class Problem43B extends GraphicsProgram{
	private static final int RADIUS = 50;
	private GPoint prevPos;
	private GObject prevObject;
	private RandomGenerator rgen = RandomGenerator.getInstance();
	
	public void init(){
		addMouseListeners(); 
		addKeyListeners();
	}
	
	public void run(){
		GOval circle = new GOval(2 * RADIUS, 2 * RADIUS);
		circle.setFilled(true);
		add(circle);
	
		
		GRect rect = new GRect(2 * RADIUS, 2 * RADIUS);
		rect.setFilled(true);
		add(rect, 100, 100);
	}
	
	public void mouseDragged(MouseEvent e){
		GObject currentObject = getElementAt(e.getX(), e.getY());
		if(currentObject != null){
			currentObject.move(e.getX() - prevPos.getX(),
					e.getY() - prevPos.getY());
			
			prevPos = new GPoint(e.getX(), e.getY());
			prevObject = currentObject; // update only when object is not null is
		}
	}
	
	public void mousePressed(MouseEvent e){
		prevPos = new GPoint(e.getX(), e.getY());
	}
	
	public void keyPressed(KeyEvent e){
		prevObject.setColor(rgen.nextColor());
	}
}
