import acm.graphics.*;
import acm.program.*;

//13. დაწერეთ პროგრამა, რომლიც ეკრანის შუაში გაავლებს ჰორიზონტალურ ხაზს.
public class Problem13 extends GraphicsProgram{
	
	public void run(){
		double length = getWidth();
		double y = getHeight()/2;
		GLine line = new GLine(0, y, length, y);
		add(line);
	}
}
