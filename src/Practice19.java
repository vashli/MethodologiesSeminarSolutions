import java.awt.event.MouseEvent;
import acm.graphics.*;
import acm.program.GraphicsProgram;

//19.  გრაფიკულ პროგრამაში დახატეთ შევსებული წრე, რომელიც, თუ დავაქლიქავთ,
//უნდა დაჰყვებოდეს მაუსს, მანამ სანამ მაუსის კურსორი კანვასს არ გაცდება.
//თავიდან შემოსვლის შემდეგ საჭიროა მეორედ ქლიქი, იმისთვის რომ წრე ისევ ამოძრავდეს.
//Tags: GraphicsProgram , MouseEvents,  MouseMoved

public class Practice19 extends GraphicsProgram{
	private static int RADIUS = 50;
	private GOval circle;
	private GPoint prevPoint;
	private boolean circleMoves = false;
	
	public void init(){
		addMouseListeners(); 
	}
	
	public void run(){
		circle = new GOval(2 * RADIUS, 2 * RADIUS);
		circle.setFilled(true);
		add(circle, getWidth()/ 2 - RADIUS , getHeight()/ 2 - RADIUS );
	}
	
	public void mouseClicked(MouseEvent e){
		if (getElementAt(e.getX(), e.getY()) != null){
			circleMoves = true;
			prevPoint = new GPoint(e.getX(), e.getY() );
		}
	}
	
	public void mouseMoved(MouseEvent e){
		if(circleMoves){
			circle.move(e.getX() - prevPoint.getX(), 
						e.getY() - prevPoint.getY());
			
			prevPoint = new GPoint(e.getX(), e.getY());
		}
	}
	
	public void mouseExited(MouseEvent e){
		circleMoves = false;
	}	
}

