import java.awt.event.KeyEvent;
import java.awt.event.MouseEvent;
import acm.graphics.*;
import acm.program.GraphicsProgram;
import acm.util.RandomGenerator;

//43B. გრაფიკულ პროგრამაში დახატეთ 2 ფიგურა: მართკუთხედი და ოვალი, ორივე იყოს შევსებული.
//თუ მაუსს დავაჭერთ რომელიმე ფიგურას და გავაკეთებთ დრაგს, ფიგურაც უნდა მოძრაობდეს 
//მანამ სანამ მაუსს ხელს არ ავუშვებთ. თუ ხელს დავაჭერთ კლავიატურის რომელიმე ღილაკს, 
//ბოლოს გამოძრავებული ფიგურა უნდა გაფერადდეს რანდომ ფერით.

//დაბლა არის ძველი ვერსიის კოდი დაკომენტარებული
//მაუსის სწრაფად მოძრაობისას პრობლემა ჰქონდა, ახალში კარგად მუშაობს და შეადარეთ
public class Problem43B extends GraphicsProgram{
	private static final int RADIUS = 50;
	private GPoint prevPos;
	private GObject prevObject;
	private GObject currentObject;
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
		if(currentObject != null){
			currentObject.move(e.getX() - prevPos.getX(),
					e.getY() - prevPos.getY());
			
			prevPos = new GPoint(e.getX(), e.getY());
		}
	}
	
	public void mousePressed(MouseEvent e){
		prevPos = new GPoint(e.getX(), e.getY());
		// we set currentObject(and prevObject) in mousePressed instead of MouseDragged
		currentObject = getElementAt(e.getX(), e.getY()); 
		if(currentObject != null){ 
			prevObject = currentObject;
		}
	}
	
	public void keyPressed(KeyEvent e){
		// prevObject is null before we drag the first object, so we need to check
		if(prevObject != null){ 
			prevObject.setColor(rgen.nextColor());
		}
	}
}


// old version

// მაუსის ძალიან სწრაფად გადაადგილებისას ფიგურა ჩერდება რადგან ერთ-ერთი შუალედური mouseDragged 
// ივენთი როცა გამოიძახება მაუსის კურსორი უკვე სხვა ადგილასაა და მის ქვეშ ობიექტი ნალია, არადა ხელი არ გაგვიშვია ობიექტისთვის

//public class Problem43B extends GraphicsProgram{
//	private static final int RADIUS = 50;
//	private GPoint prevPos;
//	private GObject prevObject;
//	private RandomGenerator rgen = RandomGenerator.getInstance();
//	
//	public void init(){
//		addMouseListeners(); 
//		addKeyListeners();
//	}
//	
//	public void run(){
//		GOval circle = new GOval(2 * RADIUS, 2 * RADIUS);
//		circle.setFilled(true);
//		add(circle);
//	
//		
//		GRect rect = new GRect(2 * RADIUS, 2 * RADIUS);
//		rect.setFilled(true);
//		add(rect, 100, 100);
//	}
//	
//	public void mouseDragged(MouseEvent e){
//		GObject currentObject = getElementAt(e.getX(), e.getY());
//		if(currentObject != null){
//			currentObject.move(e.getX() - prevPos.getX(),
//					e.getY() - prevPos.getY());
//			
//			prevPos = new GPoint(e.getX(), e.getY());
//			prevObject = currentObject; // update only when object is not null is
//		}
//	}
//	
//	public void mousePressed(MouseEvent e){
//		prevPos = new GPoint(e.getX(), e.getY());
//	}
//	
//	public void keyPressed(KeyEvent e){
//		prevObject.setColor(rgen.nextColor());
//	}
//}
