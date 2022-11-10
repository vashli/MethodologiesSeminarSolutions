import java.awt.event.MouseEvent;
import acm.graphics.*;
import acm.program.GraphicsProgram;

//44. მაუსის კლიკზე იმავე ადგილზე ჩნდება ბურთი და იწყებს ვარდნას ძირს, თუ მაუსს სხვა
//ადგილზე ვაკლიკებ ბურთი გადადის ახალ ადგილზე და იქედან იწყებს ვარდნას

public class Problem44 extends GraphicsProgram{
	private static final int RADIUS = 20;
	private static final int VELOCITY = 2;
	private GOval circle;

	public void run(){
		addMouseListeners();
		
		circle = new GOval(2 * RADIUS, 2 * RADIUS);
		circle.setFilled(true);
		while(true){
			circle.move(0, VELOCITY);
			pause(10);
		}
	}
	
	public void mouseClicked(MouseEvent e){
		add(circle, e.getX() - RADIUS, e.getY() - RADIUS);
	}
}
