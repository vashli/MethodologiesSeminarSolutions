import java.awt.event.MouseEvent;
import acm.graphics.*;
import acm.program.GraphicsProgram;

//43. წრეწირის drag ით გადაადგილება

//დაბლა არის ძველი ვერსიის კოდი დაკომენტარებული
//მაუსის სწრაფად მოძრაობისას პრობლემა ჰქონდა, ახალში კარგად მუშაობს და შეადარეთ
public class Problem43 extends GraphicsProgram{
	private static int RADIUS = 50;
	private GOval circle;
	private GPoint prevPoint;
	private GObject currentObject;
	
	public void init(){
		addMouseListeners(); 
	}
	
	public void run(){
		circle = new GOval(2 * RADIUS, 2 * RADIUS);
		circle.setFilled(true);
		add(circle, getWidth()/ 2 - RADIUS , getHeight()/ 2 - RADIUS );
	}
	
	public void mouseDragged(MouseEvent e){
//		currentObject = circle; // see what happens when you use this line instead of line 29
		if(currentObject != null){
			currentObject.move(e.getX() - prevPoint.getX(), 
					e.getY() - prevPoint.getY());
			prevPoint = new GPoint(e.getX(), e.getY());
		}
	}
	
	public void mousePressed(MouseEvent e){
		prevPoint = new GPoint(e.getX(), e.getY());
		// we set currentObject in mousePressed instead of MouseDragged
		currentObject = getElementAt(e.getX(), e.getY()); 
	}
}

//old version

//მაუსის ძალიან სწრაფად გადაადგილებისას ფიგურა ჩერდება რადგან ერთ-ერთი შუალედური mouseDragged 
//ივენთი როცა გამოიძახება მაუსის კურსორი უკვე სხვა ადგილასაა და მის ქვეშ ობიექტი ნალია, არადა ხელი არ გაგვიშვია ობიექტისთვის

//public class Problem43 extends GraphicsProgram{
//	private static int RADIUS = 50;
//	private GOval circle;
//	private GPoint prevPoint;
//	
//	public void init(){
//		addMouseListeners(); 
//	}
//	
//	public void run(){
//		circle = new GOval(2 * RADIUS, 2 * RADIUS);
//		circle.setFilled(true);
//		add(circle, getWidth()/ 2 - RADIUS , getHeight()/ 2 - RADIUS );
//	}
//	
//	public void mouseDragged(MouseEvent e){
//		GObject currentObject = getElementAt(e.getX(), e.getY());
////		GObject currentObject = circle; // see what happens when you use this line instead of line 29
//		if(currentObject != null){
//			currentObject.move(e.getX() - prevPoint.getX(), 
//					e.getY() - prevPoint.getY());
//			prevPoint = new GPoint(e.getX(), e.getY());
//		}
//	}
//	
//	public void mousePressed(MouseEvent e){
//		prevPoint = new GPoint(e.getX(), e.getY());
//	}
//}
