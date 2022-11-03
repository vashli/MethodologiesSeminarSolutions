import acm.graphics.*;
import acm.program.GraphicsProgram;

//39. დაწერეთ პროგრამა სადაც იქნება კანვასზე ბურთის მოძრაობა მარცხენა კედლის 
//შუა წერტილიდან მარჯვენა კედლამდე.
public class Problem39 extends GraphicsProgram{
	public void run(){
		int radius = 20;
		GOval circle = new GOval( 2 * radius , 2 * radius);
		circle.setFilled(true);
		add(circle, 0, getHeight() / 2 - radius);
		
		
		while(circle.getX() <= getWidth() - 2 * radius){
			circle.move(1, 0);
			pause(1);
		}
		
	}
}
